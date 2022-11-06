package com.infoshareacademy.javadabadoo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class UserFileHandler implements IUserProvider {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private ResourceLoaderClient resClient;

    @Override
    public void saveUser(User user) {
        try {
            ResourceLoader resourceLoader = new DefaultResourceLoader();
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
            ResourceLoader resourceLoader = new DefaultResourceLoader();
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
