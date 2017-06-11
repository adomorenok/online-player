package com.online.player.dto.track;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.online.player.config.CustomLocalDateTimeSerializer;
import com.online.player.dto.track.album.AlbumResponse;
import com.online.player.dto.track.author.AuthorResponse;
import com.online.player.model.track.Track;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by ikota on 11.6.17.
 */
@Data
public class TrackResponse {

    private Long id;
    private String name;
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime createdAt;
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime updatedAt;
    private AuthorResponse author;
    private AlbumResponse album;

    public TrackResponse(Track track) {
        this.id = track.getId();
        this.name = track.getName();
        this.createdAt = track.getCreatedAt();
        this.updatedAt = track.getUpdatedAt();
        this.author = new AuthorResponse(track.getAuthor());
        this.album = track.getAlbum() != null ? new AlbumResponse(track.getAlbum()) : null;
    }
}
