package com.online.player.dto.playlist;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.online.player.config.CustomLocalDateTimeSerializer;
import com.online.player.enums.PlaylistType;
import com.online.player.model.playlist.Playlist;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by ikota on 11.6.17.
 */
@Data
public class PlaylistResponse {

    private Long id;
    private String name;
    private PlaylistType type;
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime createdAt;
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime updatedAt;

    public PlaylistResponse(Playlist playlist) {
        this.id = playlist.getId();
        this.name = playlist.getName();
        this.type = playlist.getType();
        this.createdAt = playlist.getCreatedAt();
        this.updatedAt = playlist.getUpdatedAt();
    }

}
