package com.danicv.marvelapi.jwt;

import com.danicv.marvelapi.entity.UserEntity;
import com.danicv.marvelapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

//Author: Daniel Calderon
@Service
public class UserInfoService implements UserDetailsService {
    private final UserRepository repository;

    private final PasswordEncoder encoder;

    public UserInfoService(@Autowired UserRepository repository,
                           @Autowired PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> userDetail = repository.findByName(username);

        // Converting userDetail to UserDetails
        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }

    public String addUser(UserEntity userEntity) {
        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
        repository.save(userEntity);
        return "User Added Successfully";
    }
}
