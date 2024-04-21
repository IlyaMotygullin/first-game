package com.example.project_swing_jdbc.main_window;

import com.example.project_swing_jdbc.controller.WindowController;
import com.example.project_swing_jdbc.entity.User;
import com.example.project_swing_jdbc.game_panel.WindowForGame;
import com.example.project_swing_jdbc.repository.UserRepository;
import com.example.project_swing_jdbc.repository.UserRepositoryImpl;
import com.example.project_swing_jdbc.service.RegisterWindowImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Logger;
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MainWindow {
    final Logger LOGGER_INPUT = Logger.getLogger(WindowController.class.getName());

    String loginInput;

    String passwordInput;

    List<User> userList;
    UserRepository repository = new UserRepositoryImpl();

    public MainWindow() {
        userList = repository.getUsers();
    }
    //    RegisterWindow registerWindow = new RegisterWindowImpl(repository);

    //[Войти в акаунт]
    private JLabel labelInfoAll() {
        JLabel account = new JLabel();
        account.setText(String.format("[%s]", "Войти в акаунт"));
        account.setFont(new Font(Font.DIALOG, Font.BOLD, 19));
        account.setForeground(Color.WHITE);
        account.setBounds(210, 30, 200, 100);
        return account;
    }

    private JLabel labelInfoLogin() {
        JLabel login = new JLabel();
        login.setText(String.format("[%s]", "Введите логин"));
        login.setFont(new Font(Font.DIALOG, Font.BOLD, 19));
        login.setForeground(Color.WHITE);
        login.setBounds(170, 100, 200, 100);
        return login;
    }

    private JLabel labelInfoPassword() {
        JLabel password = new JLabel();
        password.setText(String.format("[%s]", "Введите пароль"));
        password.setFont(new Font(Font.DIALOG, Font.BOLD, 19));
        password.setForeground(Color.WHITE);
        password.setBounds(170, 200, 200, 100);
        return password;
    }

    public void createWindow() {
        JFrame mainWindow = new JFrame();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(600, 600);
        mainWindow.setResizable(false);
        mainWindow.setLocationRelativeTo(null);

        JTextField login = new JTextField();
        login.setSize(250, 31);
        login.setFont(new Font(Font.MONOSPACED, Font.BOLD, 19));
        login.setBounds(170, 170, login.getWidth(), login.getHeight());
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginInput = login.getText();
                LOGGER_INPUT.info("Пользователь ввел логин" + loginInput);
            }
        });

        JTextField password = new JTextField();
        password.setSize(250, 31);
        password.setFont(new Font(Font.MONOSPACED, Font.BOLD, 19));
        password.setBounds(170, 270, password.getWidth(), password.getHeight());
        password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordInput = password.getText();
                LOGGER_INPUT.info("Пользователь ввел пароль" + passwordInput);
            }
        });

        mainWindow.add(registerButton());
        mainWindow.add(entranceButton());
        mainWindow.add(login);
        mainWindow.add(password);
        mainWindow.add(labelInfoPassword());
        mainWindow.add(labelInfoLogin());
        mainWindow.add(labelInfoAll());
        mainWindow.add(new PanelBackgroundMainWindow());

        mainWindow.setVisible(true);
    }

    private JButton entranceButton() {
        JButton button = new JButton();
        button.setText(String.format("[%s]", "Войти"));
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        button.setBounds(390, 400, 150, 50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(button.getText())) {
                    for (User user : userList) {
                        if (user.getPassword().equals(passwordInput) && user.getLogin().equals(loginInput)) {
                            new WindowForGame(repository, user).createWindowForGame();
                            return;
                        }
                    }
                }
            }
        });
        return button;
    }

    private JButton registerButton() {
        JButton button = new JButton();
        button.setText(String.format("[%s]", "Регистрация"));
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        button.setBounds(50, 400, 150, 50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(button.getText())) {
                    new RegisterWindowImpl(repository).createRegisterWindow();
                }
            }
        });
        return button;
    }
}
