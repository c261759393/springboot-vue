package com.fndsoft.demonstration.entity;

import javax.persistence.*;

/**
 * @创建人 bob
 * @创建时间 2018/6/5
 * @描述：
 */
@Entity
@Table(name = "c_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
