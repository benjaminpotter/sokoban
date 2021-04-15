package com.ben.sokoban;

import java.awt.*;

public class Block {
    public Vec2d pos;

    public Block(Vec2d pos) {
        this.pos = pos;
    }

    void draw(StringBuffer buffer) {
        buffer.append("-");
    }

    public void drawSelf(Graphics2D g, int x, int y, int w, int h) {
        g.drawRect(x, y, w, h);
    }
}