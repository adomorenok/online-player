package com.online.player.dto.track.author;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.online.player.config.CustomLocalDateTimeSerializer;
import com.online.player.dto.track.tag.TagResponse;
import com.online.player.model.track.Author;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by ikota on 11.6.17.
 */
@Data
public class AuthorResponse {

    private Long id;
    private String name;
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime createdAt;
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime updatedAt;
    private Set<TagResponse> tags;

    public AuthorResponse(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.createdAt = author.getCreatedAt();
        this.updatedAt = author.getUpdatedAt();
        if (author.getTags() != null && !author.getTags().isEmpty()) {
            this.tags = author.getTags().stream().map(TagResponse::new).collect(Collectors.toSet());
        }
    }
}
