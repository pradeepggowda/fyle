package com.fyle.interview.security;

import com.fyle.interview.model.user.UserDto;
import com.fyle.interview.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository users;

    public CustomUserDetailsService(UserRepository users) {
        this.users = users;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserDto user = users.findByName(username);
            if (user == null) throw new UsernameNotFoundException(username);
            return new User(user.getUser_name(), user.getPassword(), new HashSet<>());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
