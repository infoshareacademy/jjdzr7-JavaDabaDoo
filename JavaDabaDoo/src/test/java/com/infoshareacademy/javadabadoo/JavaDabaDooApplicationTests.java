package com.infoshareacademy.javadabadoo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.javadabadoo.model.*;
import com.infoshareacademy.javadabadoo.repository.IUserProvider;
import com.infoshareacademy.javadabadoo.repository.ItemFileHandler;
import com.infoshareacademy.javadabadoo.repository.UserFileHandler;
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
        IUserProvider test = new UserFileHandler(mapper, resourceLoader);
        User user = new User(1, "admin", "admin");
        User user2 = new User(2, "biblioteka", "biblioteka");
        User user3 = new User(3, "user", "user");

        List<Integer> history = List.of(1, 2, 3);
        List<Integer> borrowed = List.of(4, 5, 6);
        ArrayList<User> users = new ArrayList<User>();

        user.setBorrowlist(borrowed);
        user.setHistory(history);
        user2.setBorrowlist(borrowed);
        user2.setHistory(history);
        user3.setBorrowlist(borrowed);
        user3.setHistory(history);
        users.add(user3);
        users.add(user);
        users.add(user2);
        test.saveUsers(users);


        ArrayList<User> users2 = test.readUsers();
        System.out.println(users.toString());
        System.out.println(users2.toString());
        assert (users2.get(0).equals(users.get(0)));
        assert (users2.get(1).equals(users.get(1)));
        assert (users2.get(2).equals(users.get(2)));
    }


    @Test
    void serializeAndDeserializeItemTest() {
        ItemFileHandler test = new ItemFileHandler();
        Item audio = new AudioBook(1L, "title", "author", Language.POLISH, "mp3", "tonieja", 2L);
        Item audio2 = new AudioBook(2L, "title", "author", Language.POLISH, "mp3", "tonieja", 2L);
        Item audio3 = new AudioBook(3L, "title", "author", Language.POLISH, "mp3", "tonieja", 2L);

        Item book = new Book(4L, "title", "author", Language.POLISH, "ISBN1", "category");
        Item book2 = new Book(5L, "title", "author", Language.POLISH, "ISBN2", "category");
        Item book3 = new Book(6L, "title", "author", Language.POLISH, "ISBN3", "category");

        Item art = new Article(7L, "title", "author", Language.POLISH, "plaskoziemcy", "category");
        Item art2 = new Article(8L, "title", "author", Language.POLISH, "antyszczepionkowcy", "category");
        Item art3 = new Article(9L, "title", "author", Language.POLISH, "inneszury", "category");

        List<Item> itemki = new ArrayList<Item>();
        itemki.add(audio);
        itemki.add(art);
        itemki.add(book);
        itemki.add(audio2);
        itemki.add(art2);
        itemki.add(book2);
        itemki.add(audio3);
        itemki.add(art3);
        itemki.add(book3);

        itemki.sort((item1, item2) -> {
            return (int) (item1.getId() - item2.getId());
        });

        test.write(itemki);
        List<Item> itemki2 = test.read();
        itemki2.sort((item1, item2) -> {
            return (int) (item1.getId() - item2.getId());
        });

        assert (itemki.get(0).equals(itemki2.get(0)));
        assert (itemki.get(1).equals(itemki2.get(1)));
        assert (itemki.get(2).equals(itemki2.get(2)));
        assert (itemki.get(3).equals(itemki2.get(3)));
        assert (itemki.get(4).equals(itemki2.get(4)));
        assert (itemki.get(5).equals(itemki2.get(5)));
        assert (itemki.get(6).equals(itemki2.get(6)));
        assert (itemki.get(7).equals(itemki2.get(7)));
        assert (itemki.get(8).equals(itemki2.get(8)));


    }
}
