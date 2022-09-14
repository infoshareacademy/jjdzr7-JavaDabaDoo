package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BooksSearchEngine {
   private Library library;
   private User user;

    static Scanner input = new Scanner(System.in);

    public BooksSearchEngine(Library library, User user) {
        this.library = library;
        this.user = user;
    }

    public void printPositions(List<Book> results) {
        if (results.isEmpty()) {
            System.out.println("\nNo positions found!\n");
            return;
        }
        for (Book result : results) {
            System.out.println(result.toString());
        }

       borrowBook();

    }

    public Book borrowBook() {
        boolean choice = askQuestion("Do you want borrow book?(yes/no)");
        int id = -1;
        if (choice) {
            System.out.println("Type id of book");
             id = input.nextInt();
            input.nextLine();

        }
        Book bookById = findBookById(id);
        user.borrowBook(bookById);
        library.booksList.remove(bookById);
        return bookById;
    }

    public Book findBookById(int id) {
        for (Book book : library.booksList) {
            if (book.getId() == id){
                return book;
            }
        }
        return null;
    }
    public Book findBorrowedBookById(int id) {
        for (Book book : user.getBorrowlist()) {
            if (book.getId() == id){
                return book;
            }
        }
        return null;
    }


    public boolean askQuestion(String question) {
        String choice = null;
        do {
            if (choice != null) {
                System.out.println("incorrect input!");
            }
            System.out.println(question);
            choice = input.nextLine().toLowerCase();
        } while (!(choice.equals("no") || choice.equals("yes")));
        if (choice.equals("yes")) {
            return true;
        } else {
            return false;
        }

    }

    private List<Book> searchBy(List<Book> listOfBooks, TypeOfSearch type, String searchedString) {

        List<Book> results = new ArrayList<>();
        for (Book book : listOfBooks) {

            switch (type) {
                case ISBN:
                    if (book.getIsbn().contains(searchedString)) {
                        results.add(book);
                    }
                    break;

                case TITLE:
                    if (book.getTitle().contains(searchedString)) {
                        results.add(book);
                    }
                    break;

                case AUTHOR:
                    if (book.getAuthor().contains(searchedString)) {
                        results.add(book);
                    }
                    break;

                case CATEGORY:
                    if (book.getCategory().contains(searchedString)) {
                        results.add(book);
                    }
                    break;

                case LANGUAGE:
                    if (book.getLanguage().contains(searchedString)) {
                        results.add(book);
                    }
                    break;
            }

        }
        return results;
    }

    private void printSearchMenu() {
        System.out.println("Search by:");
        for (TypeOfSearch type : TypeOfSearch.values()) {
            System.out.println(type.toString());
        }
    }

    private TypeOfSearch getChoice() {
        Integer choice = null;
        do {
            if (choice != null) {
                System.out.println("Incorrect choice!");
            }
            choice = (Integer.valueOf(input.nextLine()));
        } while (!(choice >= 0 && choice <= 5));
        return TypeOfSearch.values()[choice];
    }

    public void menu(List<Book> listOfBooks) {
        while (true) {
            printSearchMenu();
            TypeOfSearch choice = getChoice();
            if (choice == TypeOfSearch.EXIT) {
                break;
            }
            String searchString = input.nextLine();
            printPositions(searchBy(listOfBooks, choice, searchString));

        }
    }

}
