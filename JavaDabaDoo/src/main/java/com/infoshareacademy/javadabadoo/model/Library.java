package com.infoshareacademy.javadabadoo.model;

import com.infoshareacademy.javadabadoo.repository.FileHandler;
import com.infoshareacademy.javadabadoo.repository.IUserProvider;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private ArrayList<User> users;
    private List<Item> items;

    private IUserProvider usersProvider;
    private FileHandler itemsProvider;

    public Library() {
    }

    public Library(User user, List<Item> items, IUserProvider usersProvider, FileHandler itemsProvider) {
        this.usersProvider = usersProvider;
        this.itemsProvider = itemsProvider;
        this.users = usersProvider.readUsers();
        this.items = itemsProvider.read();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
        this.usersProvider.saveUsers(users);

    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
        this.itemsProvider.write(items);
    }

}