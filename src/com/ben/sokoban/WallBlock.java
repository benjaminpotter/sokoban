package com.ben.sokoban;

import java.awt.*;

public class WallBlock extends Block{

    public WallBlock(Vec2d pos) {
        super(pos);


    }

    @Override
    public void draw(StringBuffer buffer) {
        buffer.append("W");
    }

    @Override
    public void drawSelf(Graphics2D g, int x, int y, int w, int h) {
        g.setColor(Color.BLACK);
        super.drawSelf(g, x, y, w, h);
    }
}
