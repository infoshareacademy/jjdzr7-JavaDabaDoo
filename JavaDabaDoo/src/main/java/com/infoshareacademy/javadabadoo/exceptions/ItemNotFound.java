package com.infoshareacademy.javadabadoo.exceptions;

public class ItemNotFound extends RuntimeException {

    public ItemNotFound(Long id) {
        super("Could not find item " + id);
    }

}
