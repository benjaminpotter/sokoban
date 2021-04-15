package com.ben.sokoban;

import com.ben.sokoban.rendering.Window;

public class Sokoban {

    public static Sokoban inst;

    final int WIDTH = 10;
    final int HEIGHT = 10;

    Player player;
    Level level;

    public Level getLevel() { return level; }

    int indexFromPoint (int x, int y) { return y * WIDTH + x; }

    void loadLevel() {
        String[] levelData = LevelLoader.loadLevelDataFromFile("world.txt");
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

        new Window(); // spawn a new window

        boolean running = true;
        while (running) {

            // render
            drawLevel(level);
            Window.inst.repaint();

            // gather player input
            // gather input is blocking
            // game will wait for player input
            Vec2d input = player.gatherInput();
            player.move(input);

            // somehow exit game?
        }
    }

    public static void main (String[] args) {
        new Sokoban();
    }

}
