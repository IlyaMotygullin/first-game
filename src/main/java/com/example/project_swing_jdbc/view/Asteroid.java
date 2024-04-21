package com.example.project_swing_jdbc.view;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Asteroid {
    int y;
    int x;
    int weight = 20;
    int height = 20;
    final int speedEasy = 3;
    final int speedMedium = 5;
    final int speedHard = 7;
    final Random random = new Random();

    public Asteroid() {
    }
    public Image crateImgAsteroid() {
        ImageIcon iconASteroid = new ImageIcon("C:\\Users\\admin\\Desktop\\JavaProject\\Project_Swing_JDBC\\" +
                "src\\main\\resources\\03c7a90299ff4bc3a951ae909e26580c.png");
        Image imgAsteroid = iconASteroid.getImage();
        return imgAsteroid;
    }
    public int randomX() {
        return random.nextInt(0, 490);
    }
}
