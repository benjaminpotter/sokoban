package com.ben.sokoban;

public class WallBlock extends Block{

    public WallBlock(Vec2d pos) {
        super(pos);


    }

    @Override
    public void draw(StringBuffer buffer) {
        buffer.append("W");
    }
}
