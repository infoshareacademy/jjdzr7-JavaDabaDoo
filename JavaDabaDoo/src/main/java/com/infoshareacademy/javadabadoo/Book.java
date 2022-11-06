package com.infoshareacademy.javadabadoo;

public class Book extends Item {

    private String isbn;
    private String category;

    public Book(){

    }

    public Book(String isbn, String category) {
        this.isbn = isbn;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
