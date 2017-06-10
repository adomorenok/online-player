package com.online.player.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by ikota on 9.6.17.
 */
@Data
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private int code;

}
