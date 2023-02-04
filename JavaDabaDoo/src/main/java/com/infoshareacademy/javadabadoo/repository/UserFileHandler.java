package com.infoshareacademy.javadabadoo.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.javadabadoo.model.User;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class UserFileHandler implements IUserProvider {

    private final ObjectMapper mapper;

    private final ResourceLoader resourceLoader;

    public UserFileHandler(ObjectMapper mapper, ResourceLoader resourceLoader) {
        this.mapper = mapper;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void saveUsers(ArrayList<User> users) {
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
    public ArrayList<User> readUsers() {

        try {
            Resource resource = resourceLoader.getResource("classpath:users.json");
            File file = resource.getFile();
            return mapper.readValue(file, new TypeReference<ArrayList<User>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }
}
