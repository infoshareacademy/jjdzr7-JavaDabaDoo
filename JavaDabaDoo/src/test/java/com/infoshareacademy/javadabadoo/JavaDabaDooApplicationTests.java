package com.infoshareacademy.javadabadoo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.javadabadoo.model.Book;
import com.infoshareacademy.javadabadoo.model.Item;
import com.infoshareacademy.javadabadoo.model.Language;
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
    void serializeAndDeserializeUser() {
        // to be removed
        IUserProvider test = new UserFileHandler(mapper, resourceLoader);
        User user = new User(1, "test", "test");
        test.saveUser(user);
        List<Item> history = List.of(new Book(1, "abc javy", "Nikt wazny", Language.POLISH, "aaaaaaaaa", "lektura"));
        List<Item> borrowed = List.of(new Book(2, "abc javy i nic", "Nikt wazny", Language.POLISH, "aaaaaaaaa", "lektura"));
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

        User user2 = test.readUser();
        System.out.println(user.toString());
        System.out.println(user2.toString());
        assert (user.equals(user2));
    }

}
