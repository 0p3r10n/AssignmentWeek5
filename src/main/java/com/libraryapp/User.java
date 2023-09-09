package com.libraryapp;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Book> borrowedBooks = new ArrayList<>();
    private List<Book> favoriteBooks = new ArrayList<>();

    public void borrowBook(Library library, Book book) {
        if (library.getAllBooks().contains(book)) {
            library.removeBook(book);
            borrowedBooks.add(book);
        } else {
            throw new IllegalArgumentException("Book not available in the library.");
        }
    }

    public void returnBook(Library library, Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            library.addBook(book);
        } else {
            throw new IllegalArgumentException("Book is not borrowed by this user.");
        }
    }

    public void addToFavorites(Book book) {
        favoriteBooks.add(book);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public List<Book> getFavoriteBooks() {
        return favoriteBooks;
    }
}
