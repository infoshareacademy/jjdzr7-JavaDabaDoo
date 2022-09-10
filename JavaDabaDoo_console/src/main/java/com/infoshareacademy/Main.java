package com.infoshareacademy;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        BooksFileHandler booksFileHandler = new BooksFileHandler();
        List<Book> read = booksFileHandler.read();

        System.out.println(read);
    }
}
