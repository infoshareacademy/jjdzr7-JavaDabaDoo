package com.infoshareacademy.javadabadoo.model;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
@Entity
public class AudioBook extends Item {

    private String format;
    private String lector;
    private Long length;

    public AudioBook(long id, String title, String author, Language language, String format, String lector, Long length) {
        super(id, title, author, language);
        this.format = format;
        this.lector = lector;
        this.length = length;
    }

    public AudioBook() {

    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLector() {
        return lector;
    }

    public void setLector(String lector) {
        this.lector = lector;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AudioBook article)) return false;
        return Objects.equals(format, article.format) && Objects.equals(lector, article.lector) && Objects.equals(length, article.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(format, lector, length);
    }

    @Override
    public String toString() {
        return super.toString() + "; " + format + "; " + lector + "; " + length;
    }
}
