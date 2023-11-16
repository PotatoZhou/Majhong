package com.mahjong.springboot;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long user_id;

    private String username;
    private String password;

    // Constructors

    public User() {
        // Default constructor required by JPA
        super();
    }

    public User(String username, String password, Long user_id) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
    }

    // Getters and setters

    public Long getId() {
        return user_id;
    }

    public void setId(Long id) {
        this.user_id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
