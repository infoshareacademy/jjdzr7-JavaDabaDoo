package com.infoshareacademy;




public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");
        BooksFileHandler booksFileHandler = new BooksFileHandler();
        Library library = new Library();
        User user = new User(1, "Krzysiu", "Krawczyk");
        BooksSearchEngine booksSearchEngine = new BooksSearchEngine(library, user);



        LibraryControl libraryControl = new LibraryControl(library,booksSearchEngine,booksFileHandler, user);
        libraryControl.controlLoop();
    }
}
