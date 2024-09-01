package org.vaishnavii;

import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void testFailWithoutProperConstructor() {
        Library library = new Library("Vaishnavi");
        assertNotNull(library);
    }

    @Test
    public void testLibraryNameShouldNotbeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Library(null));
    }

    @Test
    public void testLibraryNameShouldNotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Library(""));
    }

    @Test
    public void testLibraryNameShouldBeGreaterThan4Characters() {
        assertThrows(IllegalArgumentException.class, () -> new Library("Vais"));
    }

    @Test
    public void testShouldAddBookToLibrary() {
        Library library = new Library("Drishti");

        Book book = new Book("9780132350884", "Clean Code", "Robert Cecil Martin", Year.of(2012));
        library.addBook(book);

        Book storedBook = library.getBookByISBN("9780132350884");

        assertNotNull(storedBook);
        assertEquals("9780132350884", storedBook.getISBN());
        assertEquals("Clean Code", storedBook.getTitle());
        assertEquals("Robert Cecil Martin", storedBook.getAuthor());
        assertEquals(Year.of(2012), storedBook.getPublicationYear());
    }
}
