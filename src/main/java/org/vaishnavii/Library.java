package org.vaishnavii;
import java.util.Map;

public class Library {

    String name;
    private Map<String, Book> bookInventory;

    public Library(String name) {

        if(name == null || name.isBlank() || name.length() <= 4) {
            throw new IllegalArgumentException("Library Name Should not be null or empty or should have atleast 4 characters");
        }
        this.name = name;
    }

    public void addBook(Book book) {
        bookInventory.put(book.getISBN(), book);
    }

}
