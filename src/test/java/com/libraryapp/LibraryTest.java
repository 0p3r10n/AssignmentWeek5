package com.libraryapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
        library.addBook(new Book("Book1", "Author1"));
        library.addBook(new Book("Book2", "Author2"));
        // Add more books if needed
    }

    @Test
    public void testAddBook() {
        library.addBook(new Book("Book3", "Author3"));
        List<Book> books = library.getAllBooks();
        assertEquals(3, books.size());
    }

    @Test
    public void testRemoveBook() {
        Book bookToRemove = new Book("Book1", "Author1");
        library.removeBook(bookToRemove);
        List<Book> books = library.getAllBooks();
        assertEquals(1, books.size());
        assertFalse(books.contains(bookToRemove));
    }
}
