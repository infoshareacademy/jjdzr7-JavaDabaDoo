package com.infoshareacademy.javadabadoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Component
public class ResourceLoaderClient {

    @Autowired
    private ResourceLoader resourceLoader;

    @PostConstruct
    public File getUserJson() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:user.json");
        return resource.getFile();
    }
}
