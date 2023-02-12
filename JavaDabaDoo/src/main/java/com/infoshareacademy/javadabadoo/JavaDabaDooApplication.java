package com.infoshareacademy.javadabadoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavaDabaDooApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(JavaDabaDooApplication.class, args);
//        BookRepository bookr = run.getBean(BookRepository.class);
//        AudioBookRepository audior = run.getBean(AudioBookRepository.class);
//        AudioBook audio = new AudioBook("title", "autor", Language.ENGLISH,"mp3", "WOjew", 233l);
//        Book book = new Book("title", "autor", Language.POLISH, "123456", "fantasy");
//        bookr.save(book);
//        audior.save(audio);

    }

}
