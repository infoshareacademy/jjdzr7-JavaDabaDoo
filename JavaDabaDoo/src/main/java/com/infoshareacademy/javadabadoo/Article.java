package com.infoshareacademy.javadabadoo;

public class Article extends Item {

    private String format;
    private String lektor;
    private Long dlugosc;

    public Article() {
    }

    public Article(String format, String lektor, Long dlugosc) {
        this.format = format;
        this.lektor = lektor;
        this.dlugosc = dlugosc;
    }

    @Override
    public String toString() {
        return "Article{" +
                "format='" + format + '\'' +
                ", lektor='" + lektor + '\'' +
                ", dlugosc=" + dlugosc +
                '}';
    }
}
