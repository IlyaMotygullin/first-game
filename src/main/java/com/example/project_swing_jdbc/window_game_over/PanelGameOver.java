package com.example.project_swing_jdbc.window_game_over;

import javax.swing.*;
import java.awt.*;

public class PanelGameOver extends JPanel {
    ImageIcon icon = new ImageIcon("C:\\Users\\admin\\Desktop\\JavaProject\\Project_Swing_JDBC\\src\\main\\" +
            "resources\\320f9dc047077ba56a3efc1f7025a7a2.jpg");
    Image image = icon.getImage();

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image, 0, 0, null);
    }
}
