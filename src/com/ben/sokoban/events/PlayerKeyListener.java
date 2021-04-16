package com.ben.sokoban.events;

import com.ben.sokoban.Sokoban;
import com.ben.sokoban.Vec2d;
import com.ben.sokoban.rendering.Window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();

        Vec2d result = new Vec2d(0, 0);

        switch (key) {
            case 'w':
                result = new Vec2d(0, -1);
                break;
            case 's':
                result = new Vec2d(0, 1);
                break;
            case 'a':
                result = new Vec2d(-1, 0);
                break;
            case 'd':
                result = new Vec2d(1, 0);
                break;
        }

        Sokoban.inst.player.move(result); // also probably shouldn't access the player from a singleton public reference.... so be it.
        Window.inst.repaint(); // probably shouldn't request a new repaint from here
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
