package com.infoshareacademy;


import java.util.InputMismatchException;

import java.util.Scanner;

public class LibraryControl {
    Library library;
    BooksSearchEngine booksSearchEngine;
    BooksFileHandler booksFileHandler;
    User user;

    private Scanner sc = new Scanner(System.in);


    public LibraryControl(Library library, BooksSearchEngine booksSearchEngine, BooksFileHandler booksFileHandler,
                          User user) {
        this.library = library;
        this.booksSearchEngine = booksSearchEngine;
        this.booksFileHandler = booksFileHandler;
        this.user = user;
    }

    void controlLoop() {
        library.booksList = booksFileHandler.read();
        Option option;


        do {
            printOptions();
            option = getOption();
            switch (option) {
                case SEARCH_BOOK:
                    booksSearchEngine.menu(library.booksList);
                    break;
                case ADD_BOOK:
                    //function
                    break;
                case PRINT_BOOKS:
                    booksSearchEngine.printPositions(library.booksList);
                    break;
                case DETAILS_BOOK:
                    //function
                    break;
                case BORROW_BOOK:
                    booksSearchEngine.borrowBook();

                    break;
                case PRINT_BORROWED:
                    printBorrowed();
                    break;
                case PRINT_HISTORY:
                    printBorrowHistory();
                    break;
                case PRINT_NEW_BOOKS:
                    //function
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Wrong option, please try again: ");
            }
        } while (option != Option.EXIT);
    }

    private void printBorrowed() {
        Boolean returnBook = false;
        if (user.getBorrowlist().isEmpty()) {
            System.out.println("There are no borrowed books.");
        } else {
            System.out.println("Borrowed books:");
            for (Book book : user.getBorrowlist()) {
                System.out.println(book);
            }
            returnBook = booksSearchEngine.askQuestion("Would you like to return book?");
        }
        int id = 0;
        if (returnBook) {
            System.out.println("Type id of book");
            id = sc.nextInt();
            sc.nextLine();
            Book bookById = booksSearchEngine.findBorrowedBookById(id);
            user.returnBook(bookById);
            library.booksList.add(bookById);
        }

    }
    private void printBorrowHistory() {
        if (user.getHistory().isEmpty()) {
            System.out.println("There is no history of borrowed books.");
        } else {
            System.out.println("History of borrowed books:");
            for (Book book : user.getHistory()) {
                System.out.println(book);
            }
        }
    }

    private void printOptions() {
        System.out.println("Choose option: ");
        for (Option option : Option.values()) {
            System.out.println(option.toString());
        }
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.values()[getInt()];
                optionOk = true;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try again with the option's number:");
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Number do not match the following options, try again.");
            }
        }

        return option;
    }

    public int getInt() {
        try {
            return sc.nextInt();
        } finally {
            sc.nextLine();
        }
    }

    private void exit() {

        //saving to file function
        System.out.println("Data has been successfully exported");

        sc.close();
        System.out.println("Program end, ciao!");
    }

    private enum Option {
        EXIT(0, "Exit"),
        SEARCH_BOOK(1, "Search book"),
        ADD_BOOK(2, "Add book"),
        PRINT_BOOKS(3, "Display all books"),
        DETAILS_BOOK(4, "Display book's details"),
        BORROW_BOOK(5, "Borrow book"),
        PRINT_BORROWED(6, "Display borrowed books"),
        PRINT_HISTORY(7, "Print borrow history"),
        PRINT_NEW_BOOKS(8, "Find book");


        private int value;
        private String description;

        Option(int value, String desc) {
            this.value = value;
            this.description = desc;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }


    }
}