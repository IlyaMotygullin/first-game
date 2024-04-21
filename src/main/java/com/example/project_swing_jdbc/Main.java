package com.example.project_swing_jdbc;

import com.example.project_swing_jdbc.config.MyConfig;
import com.example.project_swing_jdbc.controller.WindowController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/*
TODO: реализовать контроль для закрытия окон
TODO: реализовать окно с таблицей лидеров
 */

public class Main {
    public static void main(String[] args) throws IOException {
        var context = new AnnotationConfigApplicationContext(MyConfig.class);
        WindowController window = context.getBean("mainWindow", WindowController.class);
        window.window();
    }
}
