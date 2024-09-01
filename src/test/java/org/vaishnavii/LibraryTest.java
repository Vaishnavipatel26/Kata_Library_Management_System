package org.vaishnavii;

import org.junit.jupiter.api.Test;
import org.vaishnavii.exceptions.PermissionDeniedException;

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
    public void testShouldAllowOnlyPermittedUserToAddBook() {
        Library library = new Library("Vaishnavi");
        User user = new User("Patel", Role.LIBRARIAN);

        Book book = new Book("9780132350884", "Clean Code", "Robert Cecil Martin", Year.of(2012));

        library.addBook(user, book);

        Book storedBook = library.getBookByISBN("9780132350884");

        assertNotNull(storedBook);
        assertEquals(book, storedBook);
    }

    @Test
    public void throwExceptionIfUnauthorizedUserAddBook() {
        Library library = new Library("Vaishnavi");
        User user = new User("Patel", Role.USER);

        Book book = new Book("9780132350884", "Clean Code", "Robert Cecil Martin", Year.of(2012));
        PermissionDeniedException exception = assertThrows(PermissionDeniedException.class, () -> library.addBook(user, book));
        assertEquals("You are not authorized to add book", exception.getMessage());
    }

    @Test
    public void testShouldAddUserToLibrary() {
        Library library = new Library("Vaishnavi");
        User librarian = new User("Patel", Role.LIBRARIAN);

        library.addUser(librarian);

        User user = library.getUserByName("Patel");
        assertEquals(librarian, user);
    }
}
