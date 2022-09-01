package com.infoshareacademy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private long id;
    private String isbn;
    private String title;
    private String author;
    private String language;
    private String category;
    private List<Integer> scores;
    private LocalDateTime dateOfAdd;

    public Book() {
    }

    public Book(long id, String isbn, String title, String author, String language, String category) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.language = language;
        this.category = category;
        this.dateOfAdd = LocalDateTime.now();
        this.scores = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public LocalDateTime getDateOfAdd() {
        return dateOfAdd;
    }

    public void setDateOfAdd(LocalDateTime dateOfAdd) {
        this.dateOfAdd = dateOfAdd;
    }
}
