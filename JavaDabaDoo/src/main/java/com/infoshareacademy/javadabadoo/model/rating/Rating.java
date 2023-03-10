package com.infoshareacademy.javadabadoo.model.rating;

import com.infoshareacademy.javadabadoo.model.item.Item;
import com.infoshareacademy.javadabadoo.model.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity

public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    @Setter
    @Getter
    private Integer rating;

    public Rating() {
    }

    public Rating(User user, Item item, Integer rating) {
        this.user = user;
        this.item = item;
        this.rating = rating;
    }


}
