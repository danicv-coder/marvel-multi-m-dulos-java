package com.danicv.marvelapi.controller;

import com.danicv.marvelapi.jwt.JwtService;
import com.danicv.marvelapi.jwt.UserInfoService;
import com.danicv.marvelapi.model.AuthRequest;
import com.danicv.marvelapi.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

//Author: Daniel Calderon
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserInfoService userInfoService;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public AuthController(@Autowired UserInfoService userInfoService,
                          @Autowired AuthenticationManager authenticationManager,
                          @Autowired JwtService jwtService) {
        this.userInfoService = userInfoService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserEntity userEntity) {
        return userInfoService.addUser(userEntity);
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.username());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
