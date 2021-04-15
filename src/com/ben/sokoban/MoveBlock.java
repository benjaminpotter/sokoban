package com.ben.sokoban;

public class MoveBlock extends Block {


    public MoveBlock(Vec2d pos) {
        super(pos);
    }

    @Override
    void draw(StringBuffer buffer) {
        buffer.append("M");
    }
}
