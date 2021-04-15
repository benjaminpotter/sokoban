package com.ben.sokoban.rendering;

import com.ben.sokoban.Level;
import com.ben.sokoban.Sokoban;
import com.ben.sokoban.Block;
import com.ben.sokoban.Vec2d;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel() {
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        Level level = Sokoban.inst.getLevel();

        if (level == null)
            return;

        Block[] current = level.getCurrent();

        for (Block block : current) {
            block.drawSelf(g2d, block.pos.x * 32, block.pos.y * 32, 30, 30);
        }

        g.dispose();
    }
}
