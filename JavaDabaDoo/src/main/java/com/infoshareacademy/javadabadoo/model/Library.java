package com.infoshareacademy.javadabadoo.model;

import java.util.List;

public class Library {
    private User user;
    private List<Item> items;

    public Library() {
    }

    public Library(User user, List<Item> items) {
        this.user = user;
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}