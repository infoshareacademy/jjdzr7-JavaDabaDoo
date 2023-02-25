package com.infoshareacademy.javadabadoo.service;

import com.infoshareacademy.javadabadoo.model.user.UserCredentialsDto;
import com.infoshareacademy.javadabadoo.model.user.UserCredentialsDtoMapper;
import com.infoshareacademy.javadabadoo.model.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserCredentialsDto> findCredentialsByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserCredentialsDtoMapper::map);
    }
}
