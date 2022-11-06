package com.infoshareacademy.javadabadoo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaDabaDooApplicationTests {

    @Test
    void serializeAndDeserializeUser() {
        // to be removed
        IUserProvider test = new UserFileHandler();
        User user = new User("koko");
        test.saveUser(user);
        User user2 = test.readUser();
        assert (user.equals(user2));
    }

}
