package com.online.player.dto.user;

import com.online.player.model.user.User;
import lombok.Data;

/**
 * Created by ikota on 9.6.17.
 */
@Data
public class UserResponse {

    private Long id;
    private String name;
    private String email;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

}
