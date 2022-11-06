package com.infoshareacademy.javadabadoo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Item {
    private long id;
    private String title;
    private String author;
    private Language language;
    private List<Integer> scores;
    private LocalDateTime dateOfAdd;

    public Item(long id, String title, String author, Language language) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.language = language;
        this.dateOfAdd = LocalDateTime.now();
        this.scores = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && Objects.equals(title, item.title) && Objects.equals(author, item.author) && language == item.language && Objects.equals(scores, item.scores) && Objects.equals(dateOfAdd, item.dateOfAdd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, language, scores, dateOfAdd);
    }

    @Override
    public String toString() {
        return id + ", " + title + ", " + author + ", " + language + ", " + scores + ", " + dateOfAdd;
    }

}