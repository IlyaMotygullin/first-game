package com.example.project_swing_jdbc.service;

import com.example.project_swing_jdbc.entity.User;
import com.example.project_swing_jdbc.info_window.WindowError;
import com.example.project_swing_jdbc.main_window.MainWindow;
import com.example.project_swing_jdbc.repository.UserRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Logger;

@Service(value = "registerService")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterWindowImpl implements RegisterWindow {

    final UserRepository repository;

    List<User> userList;

    String name;

    String login;

    String password;

    final Logger LOGGER_INPUT_DATA_USERS = Logger.getLogger(RegisterWindowImpl.class.getName());

    public RegisterWindowImpl(@Qualifier(value = "userRepository") UserRepository repository) {
        this.repository = repository;
        userList = repository.getUsers();
    }

    private JLabel labelInfoAll() {
        JLabel label = new JLabel();
        label.setText(String.format("[%s]", "Регистрация"));
        label.setFont(new Font(Font.DIALOG, Font.BOLD, 19));
        label.setForeground(Color.WHITE);
        label.setBounds(210, 30, 200, 100);
        return label;
    }

    //[Введите имя]
    private JLabel labelInfoName() {
        JLabel nameLabel = new JLabel();
        nameLabel.setText(String.format("[%s]", "Введите имя"));
        nameLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 19));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(170, 100, 200, 100);
        return nameLabel;
    }

    //[Введите логин]
    private JLabel loginLabel() {
        JLabel loginLabel = new JLabel();
        loginLabel.setText(String.format("[%s]", "Введите логин"));
        loginLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 19));
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setBounds(170, 200, 200, 100);
        return loginLabel;
    }

    //[Введите пароль]
    private JLabel passwordLabel() {
        JLabel labelPassword = new JLabel();
        labelPassword.setText(String.format("[%s]", "Введите пароль"));
        labelPassword.setFont(new Font(Font.DIALOG, Font.BOLD, 19));
        labelPassword.setForeground(Color.WHITE);
        labelPassword.setBounds(170, 300, 200, 100);
        return labelPassword;
    }

    //кнопка
    @Override
    public JButton createButtonRegister() {
        JButton button = new JButton();
        button.setText(String.format("[%s]", "Регистрация"));
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 19));
        button.setBounds(390, 450, 180, 50);
        button.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(button.getText())) {
                    for (User user : userList) {
                        if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                            new WindowError(repository).createWindowError();
                            return;
                        }
                    }
                    User user = new User(name, login, password);
                    repository.createUsers(user);
                    new MainWindow().createWindow();
                }
            }
        });
        return button;
    }

    @Override
    public UserRepository getUserRepository() {
        return repository;
    }

    @Override
    public void createRegisterWindow() {
        var registerWindow = new JFrame();
        registerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerWindow.setSize(600, 600);
        registerWindow.setResizable(false);
        registerWindow.setLocationRelativeTo(null);

        JTextField fieldName = new JTextField();
        fieldName.setSize(250, 31);
        fieldName.setFont(new Font(Font.MONOSPACED, Font.BOLD, 19));
        fieldName.setBounds(170, 170, fieldName.getWidth(), fieldName.getHeight());
        fieldName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = fieldName.getText();
                LOGGER_INPUT_DATA_USERS.info("пользователь ввел имя");
            }
        });

        JTextField fieldLogin = new JTextField();
        fieldLogin.setSize(250, 31);
        fieldLogin.setFont(new Font(Font.MONOSPACED, Font.BOLD, 19));
        fieldLogin.setBounds(170, 270, fieldLogin.getWidth(), fieldLogin.getHeight());
        fieldLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login = fieldLogin.getText();
                LOGGER_INPUT_DATA_USERS.info("пользователь ввел логин");
            }
        });

        JTextField fieldPassword = new JTextField();
        fieldPassword.setSize(250, 31);
        fieldPassword.setFont(new Font(Font.MONOSPACED, Font.BOLD, 19));
        fieldPassword.setBounds(170, 370, fieldPassword.getWidth(), fieldPassword.getHeight());
        fieldPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                password = fieldPassword.getText();
                LOGGER_INPUT_DATA_USERS.info("пользователь ввел пароль");
            }
        });

        registerWindow.add(createButtonRegister());
        registerWindow.add(fieldPassword);
        registerWindow.add(fieldLogin);
        registerWindow.add(fieldName);
        registerWindow.add(passwordLabel());
        registerWindow.add(loginLabel());
        registerWindow.add(labelInfoName());
        registerWindow.add(labelInfoAll());
        registerWindow.add(new PanelBackgroundRegisterWindow());

        registerWindow.setVisible(true);
    }

    @Override
    public List<User> getUserList() {
        return userList;
    }
}
