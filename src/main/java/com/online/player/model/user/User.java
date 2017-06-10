package com.online.player.model.user;

import com.online.player.model.AbstractEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

/**
 * Created by ikota on 3.6.17.
 */
@Data
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 255)
    private String name;
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 255, unique = true)
    private String email;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
