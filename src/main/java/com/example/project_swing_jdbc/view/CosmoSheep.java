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
public class CosmoSheep {
    final int wight = 50;
    final int height = 50;
    int x;
    int y;
    int speed = 7;

    public CosmoSheep(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Image createImgSheep() {
        ImageIcon iconSheep = new ImageIcon("C:\\Users\\admin\\Desktop\\JavaProject\\Project_Swing_JDBC\\" +
                "src\\main\\resources\\Новая картинка коробля2.png");
        Image imgSheep = iconSheep.getImage();
        return imgSheep;
    }
}
