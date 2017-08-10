package com.online.player;

import com.online.player.security.JsonUsernamePasswordAuthenticationFilter;
import com.online.player.security.UnauthorizedAuthenticationFailureHandler;
import com.online.player.security.UnauthorizedEntryPoint;
import com.online.player.security.UsersDetailService;
import com.online.player.security.token.TokenAuthenticationFilter;
import com.online.player.security.token.TokenAuthenticationSuccessHandler;
import com.online.player.security.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by ikota on 6.8.17.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String tokenName = "x-token";

    @Autowired
    @Qualifier("usersDetailService")
    public UsersDetailService usersDetailService;

    @Bean
    public TokenAuthenticationFilter tokenFilter() {
        return new TokenAuthenticationFilter(usersDetailService, tokenService(), tokenName);
    }

    @Bean
    public TokenService tokenService() {
        return new TokenService(tokenName, 3600);
    }

    @Bean
    public JsonUsernamePasswordAuthenticationFilter jsonLoginFilter() {
        JsonUsernamePasswordAuthenticationFilter filter = new JsonUsernamePasswordAuthenticationFilter("username", "password");
        filter.setFilterProcessesUrl("/api/login");
        filter.setAuthenticationSuccessHandler(restSuccessHandler());
        filter.setAuthenticationFailureHandler(restFailureHandler());
        filter.setAuthenticationManager(authenticationManagerBean());
        filter.setAllowSessionCreation(true);
        return filter;
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() {
        try {
            return super.authenticationManagerBean();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Bean
    public TokenAuthenticationSuccessHandler restSuccessHandler() {
        return new TokenAuthenticationSuccessHandler(tokenService());
    }

    @Bean
    public UnauthorizedAuthenticationFailureHandler restFailureHandler() {
        return new UnauthorizedAuthenticationFailureHandler();
    }

    @Bean
    public DaoAuthenticationProvider userAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(usersDetailService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Bean
    public UnauthorizedEntryPoint unauthorizedEntryPoint() {
        return new UnauthorizedEntryPoint();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers(HttpMethod.POST, "/api/users");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/api/**")
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .addFilterAfter(tokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jsonLoginFilter(), UsernamePasswordAuthenticationFilter.class)
                .logout().disable()
                .csrf().disable()
                .httpBasic();
    }
}
