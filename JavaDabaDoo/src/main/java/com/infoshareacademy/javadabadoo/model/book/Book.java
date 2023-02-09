package com.infoshareacademy.javadabadoo.model.book;

import com.fasterxml.jackson.annotation.JsonValue;
import com.infoshareacademy.javadabadoo.model.item.Item;
import com.infoshareacademy.javadabadoo.model.Language;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Book extends Item {

    private String isbn;
    private String category;


    public Book(String title, String author, Language language, String isbn, String category) {
        super(title, author, language);
        this.isbn = isbn;
        this.category = category;
    }

    public Book() {

    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(isbn, book.isbn) && Objects.equals(category, book.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isbn, category);
    }

    @Override
    @JsonValue
    public String toString() {
        return super.toString() + "; " + isbn + "; " + category;
    }
}

