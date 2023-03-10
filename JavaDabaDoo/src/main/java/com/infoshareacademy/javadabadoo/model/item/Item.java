package com.infoshareacademy.javadabadoo.model.item;

import com.fasterxml.jackson.annotation.JsonValue;
import com.infoshareacademy.javadabadoo.model.Language;
import com.infoshareacademy.javadabadoo.model.rating.Rating;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance
public class Item {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Setter
    @Getter
    private String title;
    @Setter
    @Getter
    private String author;
    @Setter
    @Getter
    private Language language;
    @Setter
    @Getter
    @OneToMany
    @JoinColumn(name = "item_id")
    private List<Rating> scores = new ArrayList<>();
    @Setter
    @Getter
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