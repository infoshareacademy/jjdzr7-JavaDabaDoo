package com.infoshareacademy.javadabadoo;

import com.infoshareacademy.javadabadoo.model.Book;
import com.infoshareacademy.javadabadoo.model.Item;
import com.infoshareacademy.javadabadoo.model.Language;
import com.infoshareacademy.javadabadoo.repository.ItemFileHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class JavaDabaDooApplication {

    public static void main(String[] args) {
  SpringApplication.run(JavaDabaDooApplication.class, args);
//        ItemFileHandler IFH = context.getBean(ItemFileHandler.class);
//        List<Item> read = IFH.read();
//
//      //  read.forEach(System.out::println);
//        Book book = new Book(10L, "title", "autor", Language.POLISH, "123456", "fantasy");
//        read.add(book);
//        IFH.write(read);
    }

}
