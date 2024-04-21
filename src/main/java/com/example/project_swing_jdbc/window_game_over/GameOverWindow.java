package com.example.project_swing_jdbc.window_game_over;

import com.example.project_swing_jdbc.main_window.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverWindow {

    private JButton createButtonExit() {
        JButton button = new JButton();
        button.setText(String.format("[%s]", "Ok"));
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        button.setSize(120,40);
        button.setBounds(130, 240, button.getWidth(), button.getHeight());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainWindow().createWindow();
            }
        });
        return button;
    }
    public void createWindow() {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 400);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        JLabel gameOver = new JLabel();
        gameOver.setText(String.format("[%s]", "GameOver"));
        gameOver.setFont(new Font(Font.MONOSPACED, Font.BOLD, 28));
        gameOver.setForeground(Color.WHITE);
        gameOver.setSize(300,100);
        gameOver.setBounds(110, 100, gameOver.getWidth(), gameOver.getHeight());

        window.add(createButtonExit());
        window.add(gameOver);
        window.add(new PanelGameOver());
        window.setVisible(true);
    }
}
