package com.infoshareacademy.javadabadoo.service;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ItemService {
//    private final ItemFileHandler IFH;
//
//    Scanner scan = new Scanner(System.in);
//
//    public ItemService(ItemFileHandler ifh) {
//        IFH = ifh;
//    }
//
//    public Item createItem() {
//        String typeOfItem = getTypeOfItem();
//
//        return switch (typeOfItem) {
//            case "Article" -> createArticle();
//            case "Audiobook" -> createAudiobook();
//            case "Book" -> createBook();
//            default -> throw new IllegalArgumentException();
//        };
//    }
//
//    private Item createBook() {
//        System.out.println("Id: ");
//        Long id = scan.nextLong();
//        scan.nextLine();
//        System.out.println("Title: ");
//        String title = scan.nextLine();
//        System.out.println("author: ");
//        String author = scan.nextLine();
//        System.out.println("Language: ");
//        Language language = Language.valueOf(scan.nextLine());
//        System.out.println("ISBN: ");
//        String isbn = scan.nextLine();
//        System.out.println("Category: ");
//        String category = scan.nextLine();
//
//        return new Book(title, author, language, isbn, category);
//    }
//
//    private Item createAudiobook() {
//        System.out.println("Id: ");
//        Long id = scan.nextLong();
//        scan.nextLine();
//        System.out.println("Title: ");
//        String title = scan.nextLine();
//        System.out.println("author: ");
//        String author = scan.nextLine();
//        System.out.println("Language: ");
//        Language language = Language.valueOf(scan.nextLine());
//        System.out.println("Format: ");
//        String format = scan.nextLine();
//        System.out.println("Lector: ");
//        String lector = scan.nextLine();
//        System.out.println("length: ");
//        Long length = scan.nextLong();
//        scan.nextLine();
//
//        return new AudioBook(title, author, language, format, lector, length);
//    }
//
//    private Item createArticle() {
//        System.out.println("Id: ");
//        Long id = scan.nextLong();
//        scan.nextLine();
//        System.out.println("Title: ");
//        String title = scan.nextLine();
//        System.out.println("author: ");
//        String author = scan.nextLine();
//        System.out.println("Language: ");
//        Language language = Language.valueOf(scan.nextLine());
//        System.out.println("Subject: ");
//        String subject = scan.nextLine();
//        System.out.println("Source: ");
//        String source = scan.nextLine();
//
//        return new Article(title, author, language, subject, source);
//    }
//
//    private String getTypeOfItem() {
//        System.out.println("What type Item would you like to create? ");
//        return scan.nextLine();
//    }
//
//public Item deleteItem(Item item){
//        // check if exist in list
//        return item;
//}
//
//public Item updateItem(Item item){
//        //how to update?
//    return item;
//}
//

}
