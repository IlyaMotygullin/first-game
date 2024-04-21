package com.example.project_swing_jdbc.game_panel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListenerForBullet implements KeyListener {
    boolean UP;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            UP = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
