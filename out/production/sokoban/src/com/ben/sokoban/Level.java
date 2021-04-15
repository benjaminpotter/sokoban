package com.ben.sokoban;

public class Level {

    int width;
    int height;

    Block[] start;
    Block[] current;
    Block[] complete;

    public Level(Block[] start, Block[] complete) {
        this.start = start;
        this.complete = complete;

        this.current = this.start;

        // levels are 10 * 10 for now
        this.width = 10;
        this.height = 10;
    }

    private int pointToIndex (int x, int y) { return y * width + x; }

    public Block blockAtPoint(Vec2d point){ return this.current[pointToIndex(point.x, point.y)]; }

    public void swapBlocks(Vec2d first, Vec2d last) {
        int firstIndex = pointToIndex(first.x, first.y);
        int lastIndex = pointToIndex(last.x, last.y);

        Block firstBlock = this.current[firstIndex];
        this.current[firstIndex] = this.current[lastIndex];
        this.current[lastIndex] = firstBlock;

        this.current[firstIndex].pos = new Vec2d (first.x, first.y);
        this.current[lastIndex].pos = new Vec2d(last.x, last.y);
    }
}
