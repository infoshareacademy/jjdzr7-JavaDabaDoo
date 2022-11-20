package com.infoshareacademy.javadabadoo.repository;

import com.infoshareacademy.javadabadoo.model.Item;

import java.util.List;

public interface FileHandler {
    List<Item> read();

    void write(List<Item> items);
}
