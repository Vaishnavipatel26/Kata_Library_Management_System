package org.vaishnavii;
import org.vaishnavii.exceptions.PermissionDeniedException;

import java.util.*;

public class Library {

    String name;
    private final Map<String, Book> bookInventory;
    private final Map<String, User> userCatalog;

    public Library(String name) {

        if(name == null || name.isBlank() || name.length() <= 4) {
            throw new IllegalArgumentException("Library Name Should not be null or empty or should have atleast 4 characters");
        }
        this.name = name;
        this.bookInventory = new HashMap<String, Book>();
        this.userCatalog = new HashMap<String, User>();
    }

    public void addBook(User user, Book book) {
        if(user.isPermittedToAddBook()){
            bookInventory.put(book.getISBN(), book);
        } else {
            throw new PermissionDeniedException("You are not authorized to add book");
        }
    }

    public Book getBookByISBN(String isbn) {
        return bookInventory.get(isbn);
    }

}
