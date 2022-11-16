package com.infoshareacademy.javadabadoo.model;

import com.infoshareacademy.javadabadoo.model.Item;
import com.infoshareacademy.javadabadoo.model.Language;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public Article(String text) {
        String[] split = text.split("; ");
        setId(Long.parseLong(split[0]));
        setTitle(split[1]);
        setAuthor(split[2]);
        setLanguage(Language.valueOf(split[3]));
        setScores(Arrays.asList(split[4].replace("[", "").replace("]", "")
                .split(", ")).stream().map(Integer::valueOf).collect(Collectors.toList()));
        setDateOfAdd(LocalDateTime.parse(split[5]));
        this.format = split[6];
        this.lektor = split[7];
        this.dlugosc = Long.valueOf(split[8]);
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
        return super.toString() + "; " + format + "; " + lektor + "; " + dlugosc;
    }
}
