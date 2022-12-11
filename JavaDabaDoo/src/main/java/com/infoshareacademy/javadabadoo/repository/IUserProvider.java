package com.infoshareacademy.javadabadoo.repository;

import com.infoshareacademy.javadabadoo.model.User;

import java.util.List;

public interface IUserProvider {
    public void saveUsers(List<User> user);

    public List<User> readUsers();
}
