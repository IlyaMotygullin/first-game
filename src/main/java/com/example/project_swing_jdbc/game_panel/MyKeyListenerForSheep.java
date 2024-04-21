package com.example.project_swing_jdbc.game_panel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListenerForSheep implements KeyListener {
    boolean LEFT, RIGHT;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            RIGHT = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            LEFT = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            RIGHT = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            LEFT = false;
        }
    }
}
