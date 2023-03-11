package com.infoshareacademy.javadabadoo.model.user;


import com.infoshareacademy.javadabadoo.model.item.Item;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "application_user")
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
    private long id;
    ;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<UserRole> roles = new HashSet<>();

    private String firstName;
    private String lastName;
    private String email;
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

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getUserId() {
        return id;
    }

    public void setUserId(long userId) {
        this.id = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Item> getBorrowlist() {
        return borrowlist;
    }

    public void setBorrowlist(List<Item> borrowlist) {
        this.borrowlist = borrowlist;
    }

    public List<Item> getHistory() {
        return history;
    }

    public void setHistory(List<Item> history) {
        this.history = history;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}