package com.infoshareacademy.javadabadoo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class UserFileHandler implements IUserProvider {

    private final ObjectMapper mapper;

    private final ResourceLoader resourceLoader;

    public UserFileHandler(ObjectMapper mapper, ResourceLoader resourceLoader) {
        this.mapper = mapper;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void saveUser(User user) {
        try {
            Resource resource = resourceLoader.getResource("classpath:user.json");
            File file = resource.getFile();
            mapper.writeValue(file, user);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    @Override
    public User readUser() {

        try {
            Resource resource = resourceLoader.getResource("classpath:user.json");
            File file = resource.getFile();
            return mapper.readValue(file, User.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }
}
