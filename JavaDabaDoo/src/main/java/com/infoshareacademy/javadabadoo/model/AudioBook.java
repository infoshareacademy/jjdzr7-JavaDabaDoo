package com.infoshareacademy.javadabadoo.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLector() {
        return lector;
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
        this.format = split[6];
        this.lector = split[7];
        this.length = Long.valueOf(split[8]);
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
