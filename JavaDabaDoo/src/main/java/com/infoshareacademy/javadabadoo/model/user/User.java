package com.infoshareacademy.javadabadoo.model.user;


import com.infoshareacademy.javadabadoo.model.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class User {
    @OneToMany
    @JoinColumn(name = "user_id")
    public List<Item> borrowlist = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "user_id")
    public List<Item> history = new ArrayList<>();
    ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    ;
    @Setter
    @Getter
    private String firstName;
    @Setter
    @Getter
    private String lastName;

    public User(int userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && borrowlist.equals(user.borrowlist) && history.equals(user.history) && firstName.equals(user.firstName) && lastName.equals(user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(borrowlist, history, userId, firstName, lastName);
    }

    @Override
    public String toString() {
        return "User{" +
                "borrowlist=" + borrowlist +
                ", history=" + history +
                ", userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

//    public void borrowItem(Integer itemId) {
//        borrowlist.add(itemId);
//    }

//    public void returnItem(Integer itemId) {
//        if (borrowlist.contains(itemId)) {
//            borrowlist.remove(itemId);
//            history.add(itemId);
//        } else {
//            System.out.println("Brak publikacji");
//        }
//    }
}
