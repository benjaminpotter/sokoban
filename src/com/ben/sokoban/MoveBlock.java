package com.ben.sokoban;

import java.awt.*;

public class MoveBlock extends Block {


    public MoveBlock(Vec2d pos) {
        super(pos);
    }

    @Override
    void draw(StringBuffer buffer) {
        buffer.append("M");
    }

    @Override
    public void drawSelf(Graphics2D g, int x, int y, int w, int h) {
        g.setColor(Color.MAGENTA);
        super.drawSelf(g, x, y, w, h);
    }
}
