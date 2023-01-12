package com.infoshareacademy.javadabadoo.service;

import com.infoshareacademy.javadabadoo.model.*;

import java.util.Scanner;


public class ItemService {
    Scanner scan = new Scanner(System.in);

    public Item createItem() {
        String typeOfItem = getTypeOfItem();

        return switch (typeOfItem) {
            case "Article" -> createArticle();
            case "Audiobook" -> createAudiobook();
            case "Book" -> createBook();
            default -> throw new IllegalArgumentException();
        };
    }

    private Item createBook() {
        System.out.println("Id: ");
        Long id = scan.nextLong();
        scan.nextLine();
        System.out.println("Title: ");
        String title = scan.nextLine();
        System.out.println("author: ");
        String author = scan.nextLine();
        System.out.println("Language: ");
        Language language = Language.valueOf(scan.nextLine());
        System.out.println("ISBN: ");
        String isbn = scan.nextLine();
        System.out.println("Category: ");
        String category = scan.nextLine();

        return new Book(id, title, author, language, isbn, category);
    }

    private Item createAudiobook() {
        System.out.println("Id: ");
        Long id = scan.nextLong();
        scan.nextLine();
        System.out.println("Title: ");
        String title = scan.nextLine();
        System.out.println("author: ");
        String author = scan.nextLine();
        System.out.println("Language: ");
        Language language = Language.valueOf(scan.nextLine());
        System.out.println("Format: ");
        String format = scan.nextLine();
        System.out.println("Lector: ");
        String lector = scan.nextLine();
        System.out.println("length: ");
        Long length = scan.nextLong();
        scan.nextLine();

        return new AudioBook(id, title, author, language, format, lector, length);
    }

    private Item createArticle() {
        System.out.println("Id: ");
        Long id = scan.nextLong();
        scan.nextLine();
        System.out.println("Title: ");
        String title = scan.nextLine();
        System.out.println("author: ");
        String author = scan.nextLine();
        System.out.println("Language: ");
        Language language = Language.valueOf(scan.nextLine());
        System.out.println("Subject: ");
        String subject = scan.nextLine();
        System.out.println("Source: ");
        String source = scan.nextLine();

        return new Article(id, title, author, language, subject, source);
    }

    private String getTypeOfItem() {
        System.out.println("What type Item would you like to create? ");
        return scan.nextLine();
    }


}
