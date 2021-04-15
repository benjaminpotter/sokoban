package com.ben.sokoban;

public class Vec2d {

    public int x;
    public int y;

    public Vec2d() {
        this.x = 0;
        this.y = 0;
    }

    public Vec2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vec2d add(Vec2d other) {
        return new Vec2d(this.x + other.x, this.y + other.y);
    }

    public Vec2d sub(Vec2d other) {
        return new Vec2d(this.x - other.x, this.y - other.y);
    }
}
