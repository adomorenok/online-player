package com.online.player.model.user;

import com.online.player.enums.UserRole;
import com.online.player.model.AbstractEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

/**
 * Created by ikota on 3.6.17.
 */
@Entity
@Table(name = "users")
public class User extends AbstractEntity<User> {

    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 255)
    private String name;

    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 255, unique = true)
    private String email;

    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, insertable = true, updatable = true, length = 255)
    private UserRole role;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserRole getRole() {
        return role;
    }

    public User setRole(UserRole role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
