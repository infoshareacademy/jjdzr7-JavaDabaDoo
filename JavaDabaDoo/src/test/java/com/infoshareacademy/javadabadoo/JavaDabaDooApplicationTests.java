package com.infoshareacademy.javadabadoo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.javadabadoo.model.User;
import com.infoshareacademy.javadabadoo.repository.IUserProvider;
import com.infoshareacademy.javadabadoo.repository.UsersFileHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;

import java.util.ArrayList;
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
        IUserProvider test = new UsersFileHandler(mapper, resourceLoader);
        User user = new User(1, "test", "test");
        List<Integer> history = List.of(1, 2, 3);
        List<Integer> borrowed = List.of(4, 5, 6);
        user.setBorrowlist(borrowed);
        user.setHistory(history);
        User user2 = new User(1, "testt", "testt");
        List<Integer> history2 = List.of(1, 2, 3);
        List<Integer> borrowed2 = List.of(4, 5, 6);
        user2.setBorrowlist(borrowed2);
        user2.setHistory(history2);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        test.saveUsers(userList);

        List<User> user_readed = test.readUsers();

        assert (List.of(user, user2).equals(user_readed));
    }

}
