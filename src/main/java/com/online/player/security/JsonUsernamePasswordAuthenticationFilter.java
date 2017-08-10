package com.online.player.security;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(JsonUsernamePasswordAuthenticationFilter.class);

    private final String usernameFieldName;

    private final String passwordFieldName;

    private JsonFactory jsonFactory;

    public JsonUsernamePasswordAuthenticationFilter() {
        this.jsonFactory = new JsonFactory();
        this.jsonFactory.enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);
        this.jsonFactory.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
        this.usernameFieldName = "j_username";
        this.passwordFieldName = "j_password";
    }

    public JsonUsernamePasswordAuthenticationFilter(final String usernameFieldName, final String passwordFieldName) {
        this.jsonFactory = new JsonFactory();
        this.jsonFactory.enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);
        this.jsonFactory.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
        this.usernameFieldName = usernameFieldName;
        this.passwordFieldName = passwordFieldName;
    }

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }


        Pair<String, String> pair = parseCredentials(request);
        String username = pair.getA();
        String password = pair.getB();

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }

        username = username.trim();

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    private Pair<String, String> parseCredentials(HttpServletRequest request) {

        String username = null;
        String password = null;

        try (JsonParser jp = jsonFactory.createJsonParser(request.getReader())) {

            JsonToken jsonToken = jp.nextToken();
            if (jsonToken != null) {
                while (jp.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = jp.getCurrentName();
                    jp.nextToken();
                    if (usernameFieldName.equals(fieldName)) {
                        username = jp.getText();
                    } else if (passwordFieldName.equals(fieldName)) {
                        password = jp.getText();
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Cannot parse message body", e);
            throw new BadCredentialsException("Cannot parse message body", e);
        }

        return new Pair<String, String>(username, password);
    }

    private static class Pair<K, V> {

        private K a;

        private V b;

        private Pair(K a, V b) {
            this.a = a;
            this.b = b;
        }

        public K getA() {
            return a;
        }

        public V getB() {
            return b;
        }
    }

}
