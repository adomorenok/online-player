package com.online.player.model.playlist;

import com.online.player.enums.PlaylistType;
import com.online.player.model.AbstractEntity;
import com.online.player.model.user.User;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

/**
 * Created by ikota on 10.6.17.
 */
@Entity
@Table(name = "playlist")
public class Playlist extends AbstractEntity<Playlist> {

    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = true)
    private User creator;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, insertable = true, updatable = true, length = 255)
    private PlaylistType type;

    public String getName() {
        return name;
    }

    public Playlist setName(String name) {
        this.name = name;
        return this;
    }

    public User getCreator() {
        return creator;
    }

    public Playlist setCreator(User creator) {
        this.creator = creator;
        return this;
    }

    public PlaylistType getType() {
        return type;
    }

    public Playlist setType(PlaylistType type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
