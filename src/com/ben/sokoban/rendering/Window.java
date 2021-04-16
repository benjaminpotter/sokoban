package com.ben.sokoban.rendering;

import com.ben.sokoban.events.PlayerKeyListener;

import javax.swing.*;

public class Window extends JFrame {

    public static Window inst;

    final int WINDOW_WIDTH = 500;
    final int WINDOW_HEIGHT = 500;

    public Window() {
        super("Sokoban");

        inst = this; // shitty singleton

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addKeyListener(new PlayerKeyListener());

        // draw game panel
        add(new GamePanel());

        setVisible(true);
    }
}
