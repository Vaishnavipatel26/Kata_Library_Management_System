package org.vaishnavii;

import org.junit.jupiter.api.Test;
import org.vaishnavii.exceptions.PermissionDeniedException;

import java.time.Year;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    Library library = new Library("Vaishnavi");
    @Test
    public void testFailWithoutProperConstructor() {

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

        User user = new User("Patel", Role.LIBRARIAN);

        Book book = new Book("9780132350884", "Clean Code", "Robert Cecil Martin", Year.of(2012));

        library.addBook(user, book);

        Book storedBook = library.getBookByISBN("9780132350884");

        assertNotNull(storedBook);
        assertEquals(book, storedBook);
    }

    @Test
    public void throwExceptionIfUnauthorizedUserAddBook() {

        User user = new User("Patel", Role.USER);

        Book book = new Book("9780132350884", "Clean Code", "Robert Cecil Martin", Year.of(2012));
        PermissionDeniedException exception = assertThrows(PermissionDeniedException.class, () -> library.addBook(user, book));
        assertEquals("You are not authorized to add book", exception.getMessage());
    }

    @Test
    public void testShouldAddUserToLibrary() {

        User librarian = new User("Patel", Role.LIBRARIAN);

        library.addUser(librarian);

        User user = library.getUserByName("Patel");
        assertEquals(librarian, user);
    }

    @Test
    public void testShouldNotAllowDuplicateUsers() {

        User primaryLibrarian = new User("Patel", Role.LIBRARIAN);
        User secondaryLibrarian = new User("Patel", Role.LIBRARIAN);

        library.addUser(primaryLibrarian);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> library.addUser(secondaryLibrarian));
        assertEquals("User already exists in catalog", exception.getMessage());
    }

    @Test
    public void testShouldFetchUserByUsername() {

        User primaryLibrarian = new User("Patel", Role.LIBRARIAN);

        library.addUser(primaryLibrarian);
        User fetchedUser = library.getUserByName("Patel");
        assertEquals(primaryLibrarian, fetchedUser);
    }

    @Test
    public void testShouldRetrieveAllAvailableBooks() {
        User librarian = new User("Patel", Role.LIBRARIAN);
        Book book1 = new Book("9780132350884", "Clean Code", "Robert Cecil Martin", Year.of(2012));
        Book book2 = new Book("9780134685991", "Effective Java", "Joshua Bloch", Year.of(2018));

        library.addUser(librarian);
        library.addBook(librarian, book1);
        library.addBook(librarian, book2);

        Map<String, Book> availableBooks = library.viewAvailableBooks();

        assertEquals(2, availableBooks.size());
        assertTrue(availableBooks.containsKey("9780132350884"));
        assertTrue(availableBooks.containsKey("9780134685991"));
    }
}
