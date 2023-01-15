package com.infoshareacademy.javadabadoo;

import com.infoshareacademy.javadabadoo.repository.ItemFileHandler;
import com.infoshareacademy.javadabadoo.repository.UsersFileHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaDabaDooApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaDabaDooApplication.class, args);

        ItemFileHandler file = new ItemFileHandler();
        var list = file.read();
        System.out.println(list);

        UsersFileHandler user = new UsersFileHandler();
        var users = user.readUsers();
        System.out.println(users);
    }

}
