package com.ben.sokoban;

public class Block {
    Vec2d pos;

    public Block(Vec2d pos) {
        this.pos = pos;
    }

    void draw(StringBuffer buffer) {
        buffer.append("-");
    }
}