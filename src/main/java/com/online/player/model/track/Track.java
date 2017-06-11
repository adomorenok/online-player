package com.online.player.model.track;

import com.online.player.model.AbstractEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

/**
 * Created by ikota on 11.6.17.
 */
@Entity
@Table(name = "track")
public class Track extends AbstractEntity<Track> {

    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = true, updatable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "album_id", nullable = true, updatable = false)
    private Album album;

    public String getName() {
        return name;
    }

    public Track setName(String name) {
        this.name = name;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public Track setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public Album getAlbum() {
        return album;
    }

    public Track setAlbum(Album album) {
        this.album = album;
        return this;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
