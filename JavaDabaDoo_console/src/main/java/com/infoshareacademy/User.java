package com.infoshareacademy;



import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private List<Book> borrowlist;
    private List<Book> history;

    public User(int userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.borrowlist = new ArrayList<>();
        this.history = new ArrayList<>();
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

    public List<Book> getBorrowlist() {
        return borrowlist;
    }

    public void setBorrowlist(List<Book> borrowlist) {
        this.borrowlist = borrowlist;
    }

    public List<Book> getHistory() {
        return history;
    }

    public void setHistory(List<Book> history) {
        this.history = history;
    }
}
