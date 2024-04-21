package com.example.project_swing_jdbc.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    int id;
    int record;
    String name;
    String login;
    String password;

//    public User(int record, String name, String login, String password) {
//        this.record = record;
//        this.name = name;
//        this.login = login;
//        this.password = password;
//    }

    public User(int id,int record, String name, String login, String password) {
        this.id = id;
        this.record = record;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", record=" + record +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
