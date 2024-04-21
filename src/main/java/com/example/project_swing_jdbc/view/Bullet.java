package com.example.project_swing_jdbc.view;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.awt.*;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bullet {
    int x;
    int y;
    int weight = 50;
    int height = 50;
    int speedDefault = 10;
    int speedForKey = 25;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image createImgBullet() {
        ImageIcon iconBullet = new ImageIcon("C:\\Users\\admin\\Desktop\\JavaProject\\Project_Swing_JDBC\\src\\" +
                "main\\resources\\Новая картинка пули.png");
        Image imgBullet = iconBullet.getImage();
        return imgBullet;
    }
}
