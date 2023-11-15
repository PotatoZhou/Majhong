package com.mahjong.springboot;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;

@Entity
public class User {
    @id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private int user_id;

    public User(string username, string password) {
        this.username = username;
        this.password = password;
        this.user_id = user_id;

        public string getUsername() {
            return username;
        }
        public string getPassword() {
            return password;
        }

        public int getUser_id() {
            return user_id;
        }

        public void createUser(string username, string password) {
            this.username = username;
            this.password = password;
            this.user_id = user_id;
        }
    }
}