package com.infoshareacademy.javadabadoo.model.audiobook;

import com.infoshareacademy.javadabadoo.model.Language;
import com.infoshareacademy.javadabadoo.model.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class AudioBook extends Item {

    @Setter
    @Getter
    private String format;
    @Setter
    @Getter
    private String lector;
    @Setter
    @Getter
    private Long length;

    public AudioBook(String title, String author, Language language, String format, String lector, Long length) {
        super(title, author, language);
        this.format = format;
        this.lector = lector;
        this.length = length;
    }

    public AudioBook() {

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
