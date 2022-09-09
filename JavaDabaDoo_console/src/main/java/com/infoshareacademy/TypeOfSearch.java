package com.infoshareacademy;

public enum TypeOfSearch {
    ISBN(0,"ISBN"),
    TITLE(1,"Title"),
    AUTHOR(2,"Author"),
    LANGUAGE(3,"Language"),
    CATEGORY(4,"Category"),

    EXIT(5,"Exit");

    private final int value;
    private final String description;

    TypeOfSearch(int value, String description)
    {
        this.value = value;
        this.description = description;
    }
    @Override
    public String toString() {
        return value + " " + description;
    }
}
