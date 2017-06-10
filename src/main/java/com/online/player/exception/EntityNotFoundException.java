package com.online.player.exception;

/**
 * Created by ikota on 9.6.17.
 */
public class EntityNotFoundException extends WebException {

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

}
