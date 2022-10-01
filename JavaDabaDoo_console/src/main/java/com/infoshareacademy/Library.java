package com.infoshareacademy;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Library {
    List<Book> booksList;

    public Library() {
    }


    public List<Book> getSortedList(Comparator<Book> comparator) {
        booksList.sort(comparator);
        return booksList;

    }

    public void add(Book book) {
        if (book != null) {
            booksList.add(book);
        } else {
            System.out.println("Cannot add Null !");
        }


    }

    public void remove(Book book) {
        booksList.remove(book);

    }

    public Book create() {
        System.out.println("Dodaj książkę \nPodaj id : ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.toString();

        System.out.println("\nPodaj isbn : ");
        scanner = new Scanner(System.in);
        String isbn = scanner.toString();

        System.out.println("\nPodaj Tytul : ");
        scanner = new Scanner(System.in);
        String title = scanner.toString();

        System.out.println("\nPodaj Autora : ");
        scanner = new Scanner(System.in);
        String author = scanner.toString();

        System.out.println("\nPodaj Jezyk : ");
        scanner = new Scanner(System.in);
        String language = scanner.toString();

        System.out.println("\nPodaj Kategorie : ");
        scanner = new Scanner(System.in);
        String category = scanner.toString();

        return new Book(id, isbn, title, author, language, category);

    }


}
