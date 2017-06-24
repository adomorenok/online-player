package com.online.player.dto.team;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.online.player.config.CustomLocalDateTimeSerializer;
import com.online.player.model.team.Team;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by ikota on 11.6.17.
 */
@Data
public class TeamResponse {

    private Long id;
    private String name;
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime createdAt;
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime updatedAt;

    public TeamResponse(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.createdAt = team.getCreatedAt();
        this.updatedAt = team.getUpdatedAt();
    }


}
