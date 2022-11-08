package com.infoshareacademy;

public class Userclass {

    private int userId;
    private String firstName;
    private STring lastName;
    private List<Book> borrowlist;
    private List<Book> history;

    public Userclass(int userId, String firstName, String lastName) {
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

    public STring getLastName() {
        return lastName;
    }

    public void setLastName(STring lastName) {
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
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Userclass)) return false;
        if (!super.equals(object)) return false;
        Userclass userclass = (Userclass) object;
        return userId == userclass.userId && java.util.Objects.equals(firstName, userclass.firstName) && java.util.Objects.equals(lastName, userclass.lastName) && java.util.Objects.equals(borrowlist, userclass.borrowlist) && java.util.Objects.equals(history, userclass.history);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, firstName, lastName, borrowlist, history);
    }

    @Override
    public String toString(){
        return id+ ","+firstName+","+lastName;
    }
}
