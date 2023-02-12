package com.infoshareacademy.javadabadoo.model.rating;

import com.infoshareacademy.javadabadoo.model.user.User;
import com.infoshareacademy.javadabadoo.model.item.Item;

import javax.persistence.*;

@Entity

public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    private Integer rating;

    public Rating() {
    }

    public Rating(User user, Item item, Integer rating) {
        this.user = user;
        this.item = item;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getMovie() {
        return item;
    }

    public void setMovie(Item item) {
        this.item = item;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

}
