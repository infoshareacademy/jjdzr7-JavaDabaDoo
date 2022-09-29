package com.infoshareacademy;

import java.util.Comparator;
import java.util.List;

public class Library {
    List<Book> booksList;

    public Library() {
    }


    public List<Book> getSortedList(Comparator<Book> comparator) {
        booksList.sort(comparator);
        return booksList;

    }

    public void add(Book book, List<Book> getSortedList) {
        if (book != null) {
            getSortedList.add(book);
        } else {
            System.out.println("Cannot add Null !");
        }


    }


    public void remove(Book book, List<Book> getSortedList) {

        getSortedList.remove(book);

    }

    public void create() {

        Book book = new Book(
                6,
                "123-22-58-64454-2",
                "Ja Robot",
                "Isaac Asimov",
                "English",
                "Sci-fi");

    }


}
