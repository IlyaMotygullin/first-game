package com.example.project_swing_jdbc.game_panel;

import com.example.project_swing_jdbc.entity.User;
import com.example.project_swing_jdbc.repository.UserRepository;
import com.example.project_swing_jdbc.view.Asteroid;
import com.example.project_swing_jdbc.view.Bullet;
import com.example.project_swing_jdbc.view.CosmoSheep;
import com.example.project_swing_jdbc.window_game_over.GameOverWindow;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GamePanel extends JPanel implements Runnable {

    final File IMAGE_COSMOS = new File("C:\\Users\\admin\\Desktop\\JavaProject\\Project_Swing_JDBC\\src\\main\\" +
            "resources\\320f9dc047077ba56a3efc1f7025a7a2.jpg");

    final Logger LOGGER_START_PROCESS = Logger.getLogger(GamePanel.class.getName());

    boolean gameOver = true;

    Image imageCosmos = new ImageIcon(IMAGE_COSMOS.getAbsolutePath()).getImage();

    Thread thread = new Thread(this);

    CosmoSheep sheep = new CosmoSheep(250, 400);

    Asteroid asteroid = new Asteroid();

    Bullet bullet = new Bullet(sheep.getX()+23, sheep.getY() + 10);

    int countPlayer = 0;

    JLabel labelCount = new JLabel();

    MyKeyListenerForSheep keyListener = new MyKeyListenerForSheep();

    MyKeyListenerForBullet keyListenerForBullet = new MyKeyListenerForBullet();

    final UserRepository repository;

    final User user;

    java.util.List<User> userList;

    public GamePanel(UserRepository repository, User user) throws IOException {
        this.repository = repository;
        this.user = user;
        thread.start();
        this.addKeyListener(keyListener);
        this.addKeyListener(keyListenerForBullet);
        this.setFocusable(true);
        labelCount.setForeground(Color.WHITE);
        labelCount.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        labelCount.setBounds(250, 50, 100, 50);
        this.add(labelCount);
    }

    /**
     *  поучение id текущего пользователя
     * @return id пользователя
     */
    private int getCurrentUserId() {
        return user.getId();
    }

    @Override
    public void run() {
        while (thread != null && gameOver) {
            timerStart.start();
            if (thread == null) {
                timerStart.stop();
                userList = repository.getUsers();
                for (User user1 : userList) {
                    if (user1.getId() == getCurrentUserId()) {
                        if (countPlayer < user1.getRecord()) {
                            LOGGER_START_PROCESS.info("Data is not update");
                            return;
                        }
                    }
                }
                LOGGER_START_PROCESS.info("Data is update");
                repository.updateById(countPlayer, getCurrentUserId());
            }
        }
    }

    private void gameWindowSideHandler() {
        if (sheep.getX() <= 0) {
            sheep.setX(580);
        }
        if (sheep.getX() >= 585) {
            sheep.setX(0);
        }
    }

    private void keyEventHandler() {
        if (keyListener.LEFT) {
            sheep.setX(sheep.getX() - sheep.getSpeed());
            repaint();
        } else if (keyListener.RIGHT) {
            sheep.setX(sheep.getX() + sheep.getSpeed());
            repaint();
        }
    }

    Timer timerStart = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            keyEventHandler();
            gameWindowSideHandler();
            bullet.setY(bullet.getY() - bullet.getSpeedDefault());
            repaint();
            changeLevel(countPlayer);
        }
    });

    private void changeLevel(int score) {
        if (score < 50) {
            asteroid.setY(asteroid.getY() + asteroid.getSpeedEasy());
            repaint();
        } else if (score < 110) {
            asteroid.setY(asteroid.getY() + asteroid.getSpeedMedium());
            repaint();
        } else {
            asteroid.setY(asteroid.getY() + asteroid.getSpeedHard());
            repaint();
        }
    }

    private void drawImage(Graphics2D g2) {
        g2.drawImage(imageCosmos, 0, 0, null);
        g2.drawImage(sheep.createImgSheep(), sheep.getX(), sheep.getY(), this);
        g2.drawImage(asteroid.crateImgAsteroid(), asteroid.getX(), asteroid.getY(), this);
    }
    @Override
    @SneakyThrows
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawImage(g2);
        Rectangle sheepRect = new Rectangle(
                sheep.getX(),
                sheep.getY(),
                sheep.getWight(),
                sheep.getHeight()
        );
        Rectangle asteroidRect = new Rectangle(
                asteroid.getX(),
                asteroid.getY(),
                asteroid.getWeight(),
                asteroid.getHeight()
        );
        Rectangle bulletRect = new Rectangle(
                bullet.getX(),
                bullet.getY(),
                bullet.getWeight(),
                bullet.getHeight()
        );
        if (asteroid.getY() > 490) {
            asteroid = new Asteroid();
            asteroid.setX(asteroid.randomX());
            asteroid.setY(0);
        }
        g2.drawImage(
                bullet.createImgBullet(),
                bullet.getX() + 15,
                bullet.getY(),
                this
        );
        if (bullet.getY() < 50) {
            bullet = new Bullet(sheep.getX() + 15, sheep.getY());
        }
        if (asteroidRect.intersects(sheepRect)) {
            LOGGER_START_PROCESS.info("Collision");
            thread = null;
            new GameOverWindow().createWindow();
        }
        if (asteroidRect.intersects(bulletRect)) {
            bullet = new Bullet(sheep.getX(), sheep.getY());
            g2.drawImage(bullet.createImgBullet(), bullet.getX(), bullet.getY(), this);
//            LOGGER_START_PROCESS.info("Collision is find");
            asteroid.setY(-500);
            asteroid = new Asteroid();
            asteroid.setY(asteroid.getY());
            asteroid.setX(asteroid.randomX());
            g2.fillRect(asteroid.getX(), asteroid.getY(), asteroid.getWeight(), asteroid.getHeight());
            g2.setColor(Color.WHITE);
            countPlayer++;
            labelCount.setText("Count: " + countPlayer);
            LOGGER_START_PROCESS.info(String.valueOf(countPlayer));
        }
    }
}
