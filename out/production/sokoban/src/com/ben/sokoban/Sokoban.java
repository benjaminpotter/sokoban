package com.ben.sokoban;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Sokoban {

    public static Sokoban inst;

    final int WIDTH = 10;
    final int HEIGHT = 10;

    Player player;
    Block[] world = new Block[WIDTH * HEIGHT];
    Level level;

    int indexFromPoint (int x, int y) { return y * WIDTH + x; }

    /**
     * Loads a level layout string from a resource
     * @param resName name of the resource in res folder, expects file of type txt
     * @return content from file as a string
     */
    static String[] loadLevelDataFromFile(String resName) {
        StringBuilder content = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get("C:\\dev\\sokoban\\src\\res\\" + resName), StandardCharsets.UTF_8)) {
            stream.forEach(content::append);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        String[] levelLayouts = content.toString().split("-");

        // expects file to contain two copies of the level, one "starting" and one "complete"
        return levelLayouts;
    }

    void loadLevel() {
        String[] levelData = loadLevelDataFromFile("world.txt");
        String startingLayout = levelData[0];

        Block[] start = new Block[ WIDTH * HEIGHT ];

        for(int y = 0; y < HEIGHT; y++) {
            for(int x = 0; x < WIDTH; x++) {
                char blockType = startingLayout.charAt(indexFromPoint(x, y));
                Block block;

                switch (blockType) {
                    case 'W':
                        block = new WallBlock(new Vec2d(x, y));
                        break;
                    case 'M':
                        block = new MoveBlock(new Vec2d(x,y));
                        break;
                    case 'P':
                        player = new Player(new Vec2d(x ,y));
                        block = player;
                        break;
                    default:
                        block = new EmptyBlock(new Vec2d(x, y));
                }

                // technically player could end up not existing so
                // just make sure to include in the world file  :D

                world[indexFromPoint(x, y)] = block;
                start[indexFromPoint(x, y)] = block;
            }
        }

        Level level = new Level(start, start); // TODO create "end" state and check
        this.level = level;
    }

    void drawLevel(Level level) {
        StringBuffer buffer = new StringBuffer(level.width * level.height + level.height); // capacity includes space for new line characters

        for (int i = 0; i < level.current.length; i++) {
            if (i != 0 && i % WIDTH == 0)
                buffer.append("\n");

            Block block = level.current[i];
            block.draw(buffer);
        }

        System.out.println(buffer);
    }

    Sokoban() {
        inst = this;

        loadLevel();

        boolean running = true;
        while (running) {

            // render
            drawLevel(level);

            // gather player input
            // gather input is blocking
            // game will wait for player input
            char input = player.gatherInput();

            switch (input) {
                case 'w':
                    player.move(new Vec2d(0, -1));
                    break;
                case 's':
                    player.move(new Vec2d(0, 1));
                    break;
                case 'a':
                    player.move(new Vec2d(-1, 0));
                    break;
                case 'd':
                    player.move(new Vec2d(1, 0));
                    break;
                default:
                    running = false;
                    break;
            }
        }
    }

    public static void main (String[] args) {
        new Sokoban();
    }

}
