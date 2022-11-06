package com.infoshareacademy.javadabadoo;

import java.util.Objects;

public class Article extends Item {

    private String format;
    private String lektor;
    private Long dlugosc;

    public Article(long id, String title, String author, Language language, String format, String lektor, Long dlugosc) {
        super(id, title, author, language);
        this.format = format;
        this.lektor = lektor;
        this.dlugosc = dlugosc;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLektor() {
        return lektor;
    }

    public void setLektor(String lektor) {
        this.lektor = lektor;
    }

    public Long getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(Long dlugosc) {
        this.dlugosc = dlugosc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return Objects.equals(format, article.format) && Objects.equals(lektor, article.lektor) && Objects.equals(dlugosc, article.dlugosc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(format, lektor, dlugosc);
    }
    @Override
    public String toString() {
        return super.toString() + ", " + format + ", " + lektor + ", " + dlugosc;
    }
}
