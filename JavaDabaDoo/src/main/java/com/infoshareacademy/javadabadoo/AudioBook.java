package com.infoshareacademy.javadabadoo;

public class AudioBook extends Item {

    private String tematyka;
    private String zrodlo;

    public AudioBook() {
    }

    public AudioBook(String tematyka, String zrodlo) {
        this.tematyka = tematyka;
        this.zrodlo = zrodlo;
    }

    @Override
    public String toString() {
        return "AudioBook{" +
                "tematyka='" + tematyka + '\'' +
                ", zrodlo='" + zrodlo + '\'' +
                '}';
    }
}
