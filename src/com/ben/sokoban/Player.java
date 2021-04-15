package com.ben.sokoban;

import java.util.Scanner;

public class Player extends Block {

    public Player(Vec2d pos) {
        super(pos);
    }

    @Override
    void draw(StringBuffer buffer) {
        buffer.append("P");
    }

    public Vec2d gatherInput() {
        Scanner sc = new Scanner(System.in); // probably not good to create a new scanner every frame

        Vec2d result = new Vec2d(0, 0);

        switch (sc.next().charAt(0)) {
            case 'w':
                result = new Vec2d(0, -1);
                break;
            case 's':
                result = new Vec2d(0, 1);
                break;
            case 'a':
                result = new Vec2d(-1, 0);
                break;
            case 'd':
                result = new Vec2d(1, 0);
                break;
        }

        return result;
    }

    public void move(Vec2d dir) {

        // detect length of chain and validity
        Vec2d cursor = pos;
        int count = 0;

        while(true) {
            cursor = cursor.add(dir);
            Block next = Sokoban.inst.level.blockAtPoint(cursor);

            if (next instanceof WallBlock)
                return; // movement is not valid

            else if (next instanceof EmptyBlock) {
                break; // completion of chain, continue with next phase of movemnet
            }

            // move block case
            count++;
        }

        // start swapping
        for(int i = 0; i <= count; i++) {
            Sokoban.inst.level.swapBlocks(cursor, cursor.sub(dir));
            cursor = cursor.sub(dir);
        }
    }
}
