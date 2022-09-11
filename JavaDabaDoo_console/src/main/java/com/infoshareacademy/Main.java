package com.infoshareacademy;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        BooksFileHandler booksFileHandler = new BooksFileHandler();
        List<Book> read = booksFileHandler.read();

//        List<Book> add = booksFileHandler.add();
//        List<Book> remove = booksFileHandler.remove();

        System.out.println(read);
    }
}
