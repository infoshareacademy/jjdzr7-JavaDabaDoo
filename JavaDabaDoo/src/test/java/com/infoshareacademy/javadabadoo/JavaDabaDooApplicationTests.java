package com.infoshareacademy.javadabadoo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;

@SpringBootTest
class JavaDabaDooApplicationTests {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    ResourceLoader resourceLoader;

    @Test
    void serializeAndDeserializeUser() {
        // to be removed
        IUserProvider test = new UserFileHandler(mapper, resourceLoader);
        User user = new User("koko");
        test.saveUser(user);
        User user2 = test.readUser();
        assert (user.equals(user2));
    }

}
