package com.infoshareacademy.javadabadoo.model;
package com.infoshareacademy.javadabadoo.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class User {

    public List<Item> borrowlist;
    public List<Item> history;
    private int userId;
    private String firstName;
    private String lastName;

    public User(int userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.borrowlist = new ArrayList<>();
        this.history = new ArrayList<>();
    }

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof User)) return false;
        if (!super.equals(object)) return false;
        User userclass = (User) object;
        return userId == userclass.userId && java.util.Objects.equals(firstName, userclass.firstName) && java.util.Objects.equals(lastName, userclass.lastName) && java.util.Objects.equals(borrowlist, userclass.borrowlist) && java.util.Objects.equals(history, userclass.history);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, firstName, lastName, borrowlist, history);
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

    public Item borrowItem(Item item) {
        borrowlist.add(item);
        return item;
    }

    public Item returnItem(Item item) {
        if (borrowlist.contains(item)) {
            borrowlist.remove(item);
            history.add(item);
        } else {
            System.out.println("Brak publikacji");
        }
        return item;
    }
}
