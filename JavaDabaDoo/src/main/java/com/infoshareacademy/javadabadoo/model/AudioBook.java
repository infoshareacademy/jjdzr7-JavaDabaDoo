package com.infoshareacademy.javadabadoo.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class AudioBook extends Item {

    private String tematyka;
    private String zrodlo;

    public AudioBook(long id, String title, String author, Language language, String tematyka, String zrodlo) {
        super(id, title, author, language);
        this.tematyka = tematyka;
        this.zrodlo = zrodlo;
    }

    public AudioBook(String text) {
        String[] split = text.split("; ");
        setId(Long.parseLong(split[0]));
        setTitle(split[1]);
        setAuthor(split[2]);
        setLanguage(Language.valueOf(split[3]));
        setScores(Arrays.asList(split[4].replace("[", "").replace("]", "")
                .split(", ")).stream().map(Integer::valueOf).collect(Collectors.toList()));
        setDateOfAdd(LocalDateTime.parse(split[5]));
        this.tematyka = split[6];
        this.zrodlo = split[7];
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
        return super.toString() + "; " + tematyka + "; " + zrodlo;
    }
}
