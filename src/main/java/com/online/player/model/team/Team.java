package com.online.player.model.team;

import com.online.player.model.AbstractEntity;
import com.online.player.model.playlist.Playlist;
import com.online.player.model.user.User;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ikota on 11.6.17.
 */
@Entity
@Table(name = "team")
public class Team extends AbstractEntity<Team> {

    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 255)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_team", joinColumns = {
            @JoinColumn(name = "team_id", nullable = false, updatable = true)
    }, inverseJoinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = true) })
    private List<User> users;

    @ManyToOne
    @JoinColumn(name = "playlist_id", nullable = false, updatable = true)
    private Playlist playlist;

    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }

    public List<User> getUsers() {
        return users;
    }

    public Team setUsers(List<User> users) {
        this.users = users;
        return this;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public Team setPlaylist(Playlist playlist) {
        this.playlist = playlist;
        return this;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }

}
