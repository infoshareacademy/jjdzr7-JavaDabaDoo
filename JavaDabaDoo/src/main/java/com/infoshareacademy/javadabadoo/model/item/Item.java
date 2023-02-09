package com.infoshareacademy.javadabadoo.model.item;

import com.fasterxml.jackson.annotation.JsonValue;
import com.infoshareacademy.javadabadoo.model.Language;
import com.infoshareacademy.javadabadoo.model.rating.Rating;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Inheritance
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String author;
    private Language language;
    @OneToMany
    @JoinColumn(name = "item_id")
    private List<Rating> scores = new ArrayList<>();
    private LocalDateTime dateOfAdd;

    public Item() {
    }

    public Item(String title, String author, Language language) {

        this.title = title;
        this.author = author;
        this.language = language;
        this.dateOfAdd = LocalDateTime.now().withNano(0);
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

    public List<Rating> getScores() {
        return scores;
    }

    public void setScores(List<Rating> scores) {
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
    @JsonValue
    public String toString() {
        return id + "; " + title + "; " + author + "; " + language + "; " + scores + "; " + dateOfAdd;
    }

}