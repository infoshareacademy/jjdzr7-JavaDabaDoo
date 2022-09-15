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
}
