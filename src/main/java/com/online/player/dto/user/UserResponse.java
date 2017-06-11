package com.online.player.dto.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.online.player.config.CustomLocalDateTimeSerializer;
import com.online.player.enums.UserRole;
import com.online.player.model.user.User;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by ikota on 9.6.17.
 */
@Data
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private UserRole role;
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime createdAt;
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    private LocalDateTime updatedAt;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }

}
