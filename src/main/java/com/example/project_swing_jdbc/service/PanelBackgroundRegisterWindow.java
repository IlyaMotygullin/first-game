package com.example.project_swing_jdbc.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.awt.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PanelBackgroundRegisterWindow extends JPanel {
    ImageIcon iconCosmos = new ImageIcon("C:\\Users\\admin\\Desktop\\JavaProject\\Project_Swing_JDBC\\src\\" +
            "main\\resources\\320f9dc047077ba56a3efc1f7025a7a2.jpg");
    Image imgCosmos = iconCosmos.getImage();

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(imgCosmos, 0,0,null);
    }
}
