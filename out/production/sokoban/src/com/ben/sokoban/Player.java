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

    public char gatherInput() {
        Scanner sc = new Scanner(System.in); // probably not good to create a new scanner every frame
        return Character.toLowerCase(sc.next().charAt(0));
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
