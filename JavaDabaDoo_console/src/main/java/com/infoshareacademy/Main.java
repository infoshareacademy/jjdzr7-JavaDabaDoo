package com.infoshareacademy;


import java.util.ArrayList;
import java.util.List;
import com.infoshareacademy.BooksSearchEngine;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Book> list = new ArrayList<>();
        list.add(new Book(1,"abc","abc","abc","cab","abc"));
        list.add(new Book(2,"abc","abc","abc","cab","abc"));
        list.add(new Book(3,"abc","abc","abc","cab","abc"));
        list.add(new Book(4,"abc","abc","abc","cab","abc"));
        list.add(new Book(5,"abc","abc","abc","cab","abc"));
        list.add(new Book(6,"abc","abc","abc","cab","abc"));
        list.add(new Book(7,"abc","abc","abc","cab","abc"));
        list.add(new Book(8,"abc","abc","abc","cab","abc"));
        list.add(new Book(9,"abc","abc","abc","cab","abc"));
        list.add(new Book(10,"abc","abc","abc","cab","abc"));
        list.add(new Book(11,"abc","abc","abc","cab","abc"));
        list.add(new Book(12,"abc","abc","abc","cab","abc"));
        list.add(new Book(13,"abc","abc","abc","cab","abc"));
        BooksSearchEngine.menu(list);
    }
}
