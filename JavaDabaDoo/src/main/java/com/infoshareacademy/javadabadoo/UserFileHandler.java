package com.infoshareacademy.javadabadoo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@ComponentScan
public class UserFileHandler implements IUserProvider {


    @Override
    public void saveUser(User user) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource("user.json");
            InputStream input = resource.getInputStream();
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
            ObjectMapper mapper = new ObjectMapper();
            ResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource("user.json");
            InputStream input = resource.getInputStream();
            File file = resource.getFile();
            return mapper.readValue(file, User.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }
}
