package com.example.project_swing_jdbc.repository;

import com.example.project_swing_jdbc.entity.User;

import java.util.List;

public interface UserRepository {
    void createUsers(User user);
    void updateById(int record, int id);
    List<User> getUsers();
}
