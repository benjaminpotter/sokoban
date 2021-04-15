package com.ben.sokoban.rendering;

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

        // draw game panel
        add(new GamePanel());

        setVisible(true);
    }
}
