package com.cms.app.model;

import org.jboss.logging.annotations.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by burusothman on 8/31/16.
 */
@Entity
@Table(name = "users")
public class User {
    private String username;
    private String password;
    private boolean isEnabled = true;

    @Id
    @Column(name="username", nullable=false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name="password", nullable=false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="enabled", nullable=false)
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
