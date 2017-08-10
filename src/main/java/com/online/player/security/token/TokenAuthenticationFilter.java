package com.online.player.security.token;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class TokenAuthenticationFilter extends GenericFilterBean {

    private final static String FILTER_APPLIED = "_sec_cf_applied";

    private UserDetailsService userDetailsService;
    private String tokenName;

    private TokenService tokenService;

    public TokenAuthenticationFilter(UserDetailsService userDetailsService, TokenService tokenService, String tokenName) {
        this.userDetailsService = userDetailsService;
        this.tokenService = tokenService;
        this.tokenName = tokenName;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        if (Boolean.TRUE.equals(req.getAttribute(FILTER_APPLIED) != null)) {
            chain.doFilter(request, response);
            return;
        }

        String username = tokenService.extractUserName(req.getHeader("x-token"));

        // if username is null - go to the next filter
        if (username == null) {
            chain.doFilter(request, response);
            return;
        }

        UsernameNotFoundException lastException = null;
        UserDetails userDetails = null;

        try {
            userDetails = userDetailsService.loadUserByUsername(username);
            lastException = null;
        } catch (UsernameNotFoundException e) {
            lastException = e;
        }

        try {
            if (lastException != null)
                SecurityContextHolder.createEmptyContext();
            else
                SecurityContextHolder.getContext().setAuthentication(new TokenAuthentication(userDetails));

            request.setAttribute(FILTER_APPLIED, Boolean.TRUE);
            chain.doFilter(request, response);
        } finally {
            SecurityContextHolder.clearContext();
            request.removeAttribute(FILTER_APPLIED);
        }
    }


}
