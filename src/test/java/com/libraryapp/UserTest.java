package com.libraryapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private Library library;
    private User user;

    @BeforeEach
    public void setUp() {
        library = new Library();
        library.addBook(new Book("Book1", "Author1"));
        library.addBook(new Book("Book2", "Author2"));

        user = new User();
    }

    @Test
    public void testBorrowBook() {
        Book bookToBorrow = new Book("Book1", "Author1");
        user.borrowBook(library, bookToBorrow);

        List<Book> borrowedBooks = user.getBorrowedBooks();
        List<Book> libraryBooks = library.getAllBooks();

        assertTrue(borrowedBooks.contains(bookToBorrow));
        assertFalse(libraryBooks.contains(bookToBorrow));
    }

    @Test
    public void testReturnBook() {
        Book bookToReturn = new Book("Book1", "Author1");
        user.borrowBook(library, bookToReturn);
        user.returnBook(library, bookToReturn);

        List<Book> borrowedBooks = user.getBorrowedBooks();
        List<Book> libraryBooks = library.getAllBooks();

        assertFalse(borrowedBooks.contains(bookToReturn));
        assertTrue(libraryBooks.contains(bookToReturn));
    }

    @Test
    public void testAddToFavorites() {
        Book bookToAddToFavorites = new Book("Book1", "Author1");
        user.addToFavorites(bookToAddToFavorites);

        List<Book> favoriteBooks = user.getFavoriteBooks();
        assertTrue(favoriteBooks.contains(bookToAddToFavorites));
    }
}
