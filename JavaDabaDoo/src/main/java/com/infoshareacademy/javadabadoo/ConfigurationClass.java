package com.infoshareacademy.javadabadoo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationClass {

    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

}
