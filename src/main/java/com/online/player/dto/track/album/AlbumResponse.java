package com.online.player.dto.track.album;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.online.player.config.CustomLocalDateTimeSerializer;
import com.online.player.model.track.Album;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by ikota on 11.6.17.
 */
@Data
public class AlbumResponse {

    private Long id;
    private String name;
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime createdAt;
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime updatedAt;

    public AlbumResponse(Album album) {
        this.id = album.getId();
        this.name = album.getName();
        this.createdAt = album.getCreatedAt();
        this.updatedAt = album.getUpdatedAt();
    }

}
