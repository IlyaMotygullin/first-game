package com.example.project_swing_jdbc.repository;

import com.example.project_swing_jdbc.entity.User;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "userRepository")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRepositoryImpl implements UserRepository {
    final String URL = "jdbc:postgresql://localhost:5432/Game_DB";
    final String USER_NAME = "postgres";
    final String PASSWORD = "77660923050asD";
    @Override
    @SneakyThrows
    public void createUsers(User user) {
        String insertQuery = "INSERT INTO users(name_users, login_users, password_users) VALUES(?, ?, ?)";
        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setString(1, user.getName());
        statement.setString(2, user.getLogin());
        statement.setString(3, user.getPassword());
        statement.executeUpdate();
        connection.close();
    }

    @Override
    @SneakyThrows
    public void updateById(int record, int id) {
        String updateQuery = "UPDATE users SET record = ? WHERE id_users = ?";
        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        PreparedStatement statement = connection.prepareStatement(updateQuery);
        statement.setInt(1, record);
        statement.setInt(2, id);
        statement.executeUpdate();
        connection.close();
    }

    @Override
    @SneakyThrows
    public List<User> getUsers() {
        String selectQuery = "SELECT * FROM users";
        List<User> userList = new ArrayList<>();
        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        PreparedStatement statement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int idUsers = resultSet.getInt("id_users");
            String nameUsers = resultSet.getString("name_users");
            String loginUsers = resultSet.getString("login_users");
            String passwordUsers = resultSet.getString("password_users");
            int record = resultSet.getInt("record");
            userList.add(new User(idUsers, record, nameUsers, loginUsers, passwordUsers));
        }
        connection.close();
        return userList;
    }
}
