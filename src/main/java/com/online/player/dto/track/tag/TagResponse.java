package com.online.player.dto.track.tag;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.online.player.config.CustomLocalDateTimeSerializer;
import com.online.player.model.track.Tag;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by ikota on 11.6.17.
 */
@Data
public class TagResponse {

    private Long id;
    private String name;
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime createdAt;
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime updatedAt;

    public TagResponse(Tag tag) {
        this.id = tag.getId();
        this.name = tag.getName();
        this.createdAt = tag.getCreatedAt();
        this.updatedAt = tag.getUpdatedAt();
    }
}
