package com.fyle.interview.service;

import com.fyle.interview.controller.FyleServiceException;
import com.fyle.interview.model.user.UserDto;
import com.fyle.interview.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto findByName(String username) throws Exception {
        try {
            return userRepository.findByName(username);
        } catch (Exception e) {
            throw new FyleServiceException("Failed retrieve user " + username, e);
        }
    }

    public void save(UserDto userDto) throws Exception {
        try {
            if (findByName(userDto.getUser_name()) != null) {
                throw new Exception("Username already exists");
            }
            userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
            userRepository.save(userDto);
        } catch (Exception e) {
            throw new FyleServiceException("Failed to save user : " + e.getLocalizedMessage(), e);
        }
    }

}
