package com.infoshareacademy.javadabadoo.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Book extends Item {

    private String isbn;
    private String category;


    public Book(long id, String title, String author, Language language, String isbn, String category) {
        super(id, title, author, language);
        this.isbn = isbn;
        this.category = category;
    }

    public Book(String text) {
        String[] split = text.split("; ");
        setId(Long.parseLong(split[0]));
        setTitle(split[1]);
        setAuthor(split[2]);
        setLanguage(Language.valueOf(split[3]));
        String scoreString = split[4].replace("[", "").replace("]", "");
        setScores(Arrays.asList(scoreString.split(", ")).stream().map(Integer::valueOf)
                .collect(Collectors.toList()));
        setDateOfAdd(LocalDateTime.parse(split[5]));
        this.isbn = split[6];
        this.category = split[7];
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

