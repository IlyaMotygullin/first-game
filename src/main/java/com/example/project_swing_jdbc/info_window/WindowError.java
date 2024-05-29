package com.example.project_swing_jdbc.info_window;

import com.example.project_swing_jdbc.repository.UserRepository;
import com.example.project_swing_jdbc.service.RegisterWindowImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WindowError {
    final UserRepository repository;

    public WindowError(UserRepository repository) {
        this.repository = repository;
    }

    private JLabel createLabelInfo() {
        JLabel label = new JLabel();
        label.setText(String.format("[%s]", "Данный пользователь существует"));
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        label.setForeground(Color.WHITE);
        label.setSize(300, 80);
        label.setBounds(100,50, label.getWidth(), label.getHeight());
        return label;
    }

    private JButton createButton() {
        JButton button = new JButton();
        button.setText(String.format("[%s]", "Ок"));
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 17));
        button.setBounds(180,150,100,45);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterWindowImpl(repository).createRegisterWindow();
            }
        });
        return button;
    }
    public void createWindowError() {
        JFrame windowError = new JFrame();
        windowError.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowError.setSize(500,300);
        windowError.setResizable(false);
        windowError.setLocationRelativeTo(null);

        windowError.add(createLabelInfo());
        windowError.add(createButton());
        windowError.add(new PanelForWindowErr());

        windowError.setVisible(true);
    }
}
