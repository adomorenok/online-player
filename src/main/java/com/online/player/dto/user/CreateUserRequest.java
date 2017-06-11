package com.online.player.dto.user;

import lombok.Data;

/**
 * Created by ikota on 9.6.17.
 */
@Data
public class CreateUserRequest {

    private String name;
    private String email;
    private String password;

}
