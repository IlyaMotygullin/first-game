package com.example.project_swing_jdbc.service;

import com.example.project_swing_jdbc.entity.User;
import com.example.project_swing_jdbc.repository.UserRepository;

import javax.swing.*;
import java.util.List;

public interface RegisterWindow {
    void createRegisterWindow();
    JButton createButtonRegister();
    UserRepository getUserRepository();
    List<User> getUserList();
}
