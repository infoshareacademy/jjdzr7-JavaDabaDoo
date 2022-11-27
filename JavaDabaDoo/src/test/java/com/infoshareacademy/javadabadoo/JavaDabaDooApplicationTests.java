package com.infoshareacademy.javadabadoo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.javadabadoo.model.User;
import com.infoshareacademy.javadabadoo.repository.IUserProvider;
import com.infoshareacademy.javadabadoo.repository.UserFileHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;

import java.util.List;

@SpringBootTest
class JavaDabaDooApplicationTests {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    ResourceLoader resourceLoader;

    @Test
    void serializeAndDeserializeUserTest() {
        // to be removed
        IUserProvider test = new UserFileHandler(mapper, resourceLoader);
        User user = new User(1, "test", "test");
        List<Integer> history = List.of(1, 2, 3);
        List<Integer> borrowed = List.of(4, 5, 6);
        user.setBorrowlist(borrowed);
        user.setHistory(history);
        test.saveUser(user);

        User user2 = test.readUser();
        System.out.println(user.toString());
        System.out.println(user2.toString());
        assert (user.equals(user2));
    }

}
