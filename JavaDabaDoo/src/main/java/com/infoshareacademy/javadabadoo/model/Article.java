package com.infoshareacademy.javadabadoo.model;

import com.infoshareacademy.javadabadoo.model.Item;
import com.infoshareacademy.javadabadoo.model.Language;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Article extends Item {

    private String subject;
    private String source;

    public Article(long id, String title, String author, Language language, String subject, String source) {
        super(id, title, author, language);
        this.subject = subject;
        this.source = source;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article audioBook)) return false;
        return Objects.equals(subject, audioBook.subject) && Objects.equals(source, audioBook.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, source);
    }

    @Override
    public String toString() {
        return super.toString() + "; " + format + "; " + lektor + "; " + dlugosc;
    }
}
