package com.infoshareacademy.javadabadoo.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.javadabadoo.model.User;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class UsersFileHandler implements IUserProvider {

    private final ObjectMapper mapper;

    private final ResourceLoader resourceLoader;

    public UsersFileHandler(ObjectMapper mapper, ResourceLoader resourceLoader) {
        this.mapper = mapper;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void saveUsers(List<User> users) {
        try {
            Resource resource = resourceLoader.getResource("classpath:users.json");
            File file = resource.getFile();
            mapper.writeValue(file, users);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    @Override
    public List<User> readUsers() {

        try {
            Resource resource = resourceLoader.getResource("classpath:users.json");
            File file = resource.getFile();
            return mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }
}
