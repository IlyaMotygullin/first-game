package com.example.project_swing_jdbc.controller;

import com.example.project_swing_jdbc.main_window.MainWindow;
import com.example.project_swing_jdbc.service.RegisterWindow;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller(value = "mainWindow")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WindowController {
    MainWindow window = new MainWindow();

    final RegisterWindow registerWindow;

    @Autowired
    public WindowController(RegisterWindow registerWindow) {
        this.registerWindow = registerWindow;
    }

    public void window() {
        window.createWindow();
    }
}
