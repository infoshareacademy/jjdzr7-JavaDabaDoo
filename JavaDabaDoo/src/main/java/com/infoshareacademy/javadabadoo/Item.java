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
}