package com.infoshareacademy.javadabadoo.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class User {

    public List<Integer> borrowlist;
    public List<Integer> history;
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

    public List<Integer> getBorrowlist() {
        return borrowlist;
    }

    public void setBorrowlist(List<Integer> borrowlist) {
        this.borrowlist = borrowlist;
    }

    public List<Integer> getHistory() {
        return history;
    }

    public void setHistory(List<Integer> history) {
        this.history = history;
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

    public void borrowItem(Integer itemId) {
        borrowlist.add(itemId);
    }

    public void returnItem(Integer itemId) {
        if (borrowlist.contains(itemId)) {
            borrowlist.remove(itemId);
            history.add(itemId);
        } else {
            System.out.println("Brak publikacji");
        }
    }
}
