package com.online.player.model.track;

import com.online.player.model.AbstractEntity;
import com.online.player.model.playlist.Playlist;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by ikota on 11.6.17.
 */
@Entity
@Table(name = "playlist_track")
public class PlaylistTrack extends AbstractEntity<PlaylistTrack> {

    @ManyToOne
    @JoinColumn(name = "playlist_id", nullable = true, updatable = false)
    private Playlist playlist;

    @ManyToOne
    @JoinColumn(name = "track_id", nullable = true, updatable = false)
    private Track track;

    public Playlist getPlaylist() {
        return playlist;
    }

    public PlaylistTrack setPlaylist(Playlist playlist) {
        this.playlist = playlist;
        return this;
    }

    public Track getTrack() {
        return track;
    }

    public PlaylistTrack setTrack(Track track) {
        this.track = track;
        return this;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
