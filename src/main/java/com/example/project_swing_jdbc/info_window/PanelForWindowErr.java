package com.example.project_swing_jdbc.info_window;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.awt.*;
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PanelForWindowErr extends JPanel {
    ImageIcon iconCosmos = new ImageIcon("C:\\Users\\admin\\Desktop\\JavaProject\\Project_Swing_JDBC\\" +
            "src\\main\\resources\\41686792_images_4684452440.jpg");
    Image imgCosmos = iconCosmos.getImage();
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(imgCosmos, 0, 0, null);
    }
}
