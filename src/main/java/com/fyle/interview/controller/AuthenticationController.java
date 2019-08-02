package com.fyle.interview.controller;


import com.fyle.interview.controller.viewmode.request.AuthenticationRequestModel;
import com.fyle.interview.controller.viewmode.request.UserSignupModel;
import com.fyle.interview.controller.viewmode.response.UserViewModel;
import com.fyle.interview.model.user.UserDto;
import com.fyle.interview.security.jwt.JwtTokenProvider;
import com.fyle.interview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserService users;


    @PostMapping("/signin")
    public ResponseEntity login(@RequestBody AuthenticationRequestModel data) {

        try {
            String username = data.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            String token = jwtTokenProvider.createToken(username);

            return ok(token);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }


    @PostMapping("/singup")
    public ResponseEntity singup(@RequestBody UserSignupModel data) throws Exception {

        String username = data.getUsername();

        UserDto userDto = new UserDto();
        userDto.setEmail_id(data.getEmailId());
        userDto.setPassword(data.getPassword());
        userDto.setUser_name(data.getUsername());

        users.save(userDto);
        UserDto user = users.findByName(username);

        UserViewModel userViewModel = new UserViewModel();
        userViewModel.setEmailId(user.getEmail_id());
        userViewModel.setUsername(user.getUser_name());

        String token = jwtTokenProvider.createToken(username);
        Map<Object, Object> model = new HashMap<>();
        model.put("user", userViewModel);
        model.put("token", token);
        return ok(model);
    }
}
