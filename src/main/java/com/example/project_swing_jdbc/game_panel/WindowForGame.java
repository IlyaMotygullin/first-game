package com.example.project_swing_jdbc.game_panel;

import com.example.project_swing_jdbc.entity.User;
import com.example.project_swing_jdbc.repository.UserRepository;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.awt.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class WindowForGame extends JFrame {

    final UserRepository repository;
    final User user;

    public WindowForGame(UserRepository repository, User user) throws HeadlessException {
        this.repository = repository;
        this.user = user;
    }

    @SneakyThrows
    public void createWindowForGame() {
        JFrame gameWindow = new JFrame();
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(600,600);
        gameWindow.setResizable(false);
        gameWindow.setLocationRelativeTo(null);

        gameWindow.add(new GamePanel(repository, user));

        gameWindow.setVisible(true);
    }
}
