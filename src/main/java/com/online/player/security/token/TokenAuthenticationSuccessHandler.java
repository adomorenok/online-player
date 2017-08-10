package com.online.player.security.token;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private TokenService tokenService;

    public TokenAuthenticationSuccessHandler(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails userDetails = (UserDetails) securityContext.getAuthentication().getPrincipal();

        response.addHeader("x-token", tokenService.createToken(userDetails.getUsername()).toString());
/*
        String redirectUrl = defaultSuccessUrl;
        if (profileReturn)
            redirectUrl = defaultSuccessUrl + "/" + authentication.getName();

        response.setStatus(HttpServletResponse.SC_SEE_OTHER);
        response.addHeader("Location", redirectUrl);*/
    }
}

