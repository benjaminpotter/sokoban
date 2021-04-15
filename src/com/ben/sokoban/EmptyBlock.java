package com.ben.sokoban;

public class EmptyBlock extends Block {


    public EmptyBlock(Vec2d pos) {
        super(pos);
    }

    @Override
    void draw(StringBuffer buffer) {
        buffer.append(".");
    }
}
