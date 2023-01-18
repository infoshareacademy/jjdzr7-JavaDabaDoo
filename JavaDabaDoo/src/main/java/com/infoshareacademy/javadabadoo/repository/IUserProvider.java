package com.infoshareacademy.javadabadoo.repository;

import com.infoshareacademy.javadabadoo.model.User;

public interface IUserProvider {
    public void saveUser(User user);

    public User readUser();
}
