package com.infoshareacademy.javadabadoo;

import java.util.Objects;

public class AudioBook extends Item {

    private String tematyka;
    private String zrodlo;

    public AudioBook(long id, String title, String author, Language language, String tematyka, String zrodlo) {
        super(id, title, author, language);
        this.tematyka = tematyka;
        this.zrodlo = zrodlo;
    }

    public String getTematyka() {
        return tematyka;
    }

    public void setTematyka(String tematyka) {
        this.tematyka = tematyka;
    }

    public String getZrodlo() {
        return zrodlo;
    }

    public void setZrodlo(String zrodlo) {
        this.zrodlo = zrodlo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AudioBook audioBook)) return false;
        return Objects.equals(tematyka, audioBook.tematyka) && Objects.equals(zrodlo, audioBook.zrodlo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tematyka, zrodlo);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + tematyka + ", " + zrodlo;
    }
}
