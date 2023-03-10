package com.infoshareacademy.javadabadoo.model.user;


import com.infoshareacademy.javadabadoo.model.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @OneToMany
    @JoinColumn(name = "user_id")
    @Setter
    @Getter
    public List<Item> borrowlist = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "user_id")
    @Setter
    @Getter
    public List<Item> history = new ArrayList<>();
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    ;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    @Setter
    @Getter
    private Set<UserRole> roles = new HashSet<>();

    private String firstName;
    @Setter
    @Getter
    private String lastName;
    @Setter
    @Getter
    private String email;
    @Setter
    @Getter
    private String password;

    public User(int userId, String firstName, String lastName, String email, String password) {
        this.id = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(borrowlist, user.borrowlist) && Objects.equals(history, user.history) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, borrowlist, history, firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + id +
                ", borrowlist=" + borrowlist +
                ", history=" + history +
                ", userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
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
