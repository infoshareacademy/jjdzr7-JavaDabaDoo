package com.infoshareacademy.javadabadoo.repository;

import com.infoshareacademy.javadabadoo.model.User;

import java.util.ArrayList;

public interface IUserProvider {

    public void saveUsers(ArrayList<User> user);

    public ArrayList<User> readUsers();
}
