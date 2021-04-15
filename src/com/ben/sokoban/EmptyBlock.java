package com.ben.sokoban;

import java.awt.*;

public class EmptyBlock extends Block {


    public EmptyBlock(Vec2d pos) {
        super(pos);
    }

    @Override
    void draw(StringBuffer buffer) {
        buffer.append(".");
    }

    @Override
    public void drawSelf(Graphics2D g, int x, int y, int w, int h) {
        g.setColor(Color.white);
        super.drawSelf(g, x, y, w, h);
    }
}
