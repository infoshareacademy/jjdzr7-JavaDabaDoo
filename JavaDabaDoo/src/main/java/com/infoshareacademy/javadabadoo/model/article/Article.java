package com.infoshareacademy.javadabadoo.model.article;

import com.infoshareacademy.javadabadoo.model.item.Item;
import com.infoshareacademy.javadabadoo.model.Language;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Article extends Item {

    private String subject;
    private String source;

    public Article(String title, String author, Language language, String subject, String source) {
        super(title, author, language);
        this.subject = subject;
        this.source = source;
    }

    public Article() {

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
        return super.toString() + "; " + subject + "; " + source;
    }
}