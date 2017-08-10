package com.online.player.security.token;

import com.online.player.security.CryptException;
import com.online.player.security.CryptUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;

public class TokenService {


    private static final Logger logger = LoggerFactory.getLogger(TokenService.class);

    private final String tokenName;

    private final int maxAge;

    private final CryptUtils cryptUtils;

    public TokenService() {
        this("x-token", 86400);
    }

    public TokenService(String tokenName) {
        this(tokenName, 0);
    }

    public TokenService(String tokenName, int maxAge) {
        this.tokenName = tokenName;
        this.maxAge = maxAge;
        this.cryptUtils = CryptUtils.getInstance();
    }

    public String extractUserName(String token) throws ServletException {
        String username = null;

        if (token == null) {
            return username;
        }

        String[] splitToken = token.split(":");

        if (splitToken.length != 2) {
            return username;
        }

        String codeUserName = splitToken[1].substring(0, splitToken[1].length() - 1);

        try {
            username = decode(codeUserName);
        } catch (Throwable e) {
            logger.warn("Failed to decode cookie value", e);
            throw new ServletException(e);
        }

        return username;
    }

    public Token createToken(String userName) throws ServletException {
        Token token = null;
        try {
            token = new Token(tokenName, encode(userName));
            token.setMaxAge(maxAge);
        } catch (CryptException e) {
            throw new ServletException(e);
        }
        return token;
    }

    private String encode(String raw) throws CryptException {
        return cryptUtils.encode(raw);
    }

    private String decode(String encoded) throws CryptException {
        return cryptUtils.decode(encoded);
    }


}
