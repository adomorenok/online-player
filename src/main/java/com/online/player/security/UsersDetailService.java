package com.online.player.security;

import com.online.player.enums.UserRole;
import com.online.player.model.user.User;
import com.online.player.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;

@Service("usersDetailService")
@Transactional
public class UsersDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        user.setRole(UserRole.ADMIN);
        user = userRepository.save(user);
        if (user == null) {
            throw new UsernameNotFoundException("user is not found");
        }

        ArrayList<GrantedAuthority> authorities = new ArrayList<>(1);
        Arrays.asList(new SimpleGrantedAuthority(user.getRole().name()));

        return new CustomUser(user.getEmail(), user.getPassword(), authorities);
    }

}
