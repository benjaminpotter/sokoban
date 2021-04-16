package com.ben.sokoban;

import java.awt.*;
import java.util.Scanner;

public class Player extends Block {

    public Player(Vec2d pos) {
        super(pos);
    }

    @Override
    public void drawSelf(Graphics2D g, int x, int y, int w, int h) {
        g.setColor(Color.blue);
        super.drawSelf(g, x, y, w, h);
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
