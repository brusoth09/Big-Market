package com.cms.app.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by burusothman on 8/31/16.
 */
@Entity
@Table(name = "user_roles")
public class Role {
    private int user_role_id;
    private String username;
    private String role;

    @Id @GeneratedValue(strategy=IDENTITY)
    public int getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
