package com.online.player.security.token;

import javax.servlet.http.Cookie;

public class Token extends Cookie {

    public Token(String name, String value) {
        super(name, value);
    }

    @Override
    public String toString() {
        return "{" + this.getName() + ":" + this.getValue() + "}";
    }
}
