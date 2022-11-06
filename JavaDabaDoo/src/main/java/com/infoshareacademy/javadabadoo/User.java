package com.infoshareacademy.javadabadoo;

import java.util.Objects;

public class User {
    public String UnecceserryTextField = "Remove this line";

    public User(String unecceserryTextField) {
        UnecceserryTextField = unecceserryTextField;
    }

    public User() {
    }

    public String getUnecceserryTextField() {
        return UnecceserryTextField;
    }

    public void setUnecceserryTextField(String unecceserryTextField) {
        UnecceserryTextField = unecceserryTextField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(UnecceserryTextField, user.UnecceserryTextField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UnecceserryTextField);
    }
}
