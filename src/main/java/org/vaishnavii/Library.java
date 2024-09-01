package org.vaishnavii;
import java.util.*;

public class Library {

    String name;
    private final Map<String, Book> bookInventory;

    public Library(String name) {

        if(name == null || name.isBlank() || name.length() <= 4) {
            throw new IllegalArgumentException("Library Name Should not be null or empty or should have atleast 4 characters");
        }
        this.name = name;
        this.bookInventory = new HashMap<String, Book>();
    }

    public void addBook(Book book) {
        bookInventory.put(book.getISBN(), book);
    }

    public Book getBookByISBN(String isbn) {
        return bookInventory.get(isbn);
    }

}
