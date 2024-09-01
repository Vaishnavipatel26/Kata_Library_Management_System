package org.vaishnavii;
import org.vaishnavii.exceptions.PermissionDeniedException;

import java.util.*;

public class Library {

    String name;
    private final Map<String, Book> bookInventory;
    private final Map<String, User> userCatalog;
    private final Map<String, String> borrowedBooks;
    private final Map<String, Book> borrowedBookDetails;

    public Library(String name) {

        if(name == null || name.isBlank() || name.length() <= 4) {
            throw new IllegalArgumentException("Library Name Should not be null or empty or should have atleast 4 characters");
        }
        this.name = name;
        this.bookInventory = new HashMap<String, Book>();
        this.userCatalog = new HashMap<String, User>();
        this.borrowedBooks = new HashMap<String, String>();
        this.borrowedBookDetails = new HashMap<String, Book>();
    }

    public void addUser(User user) {

        if(userCatalog.containsKey(user.getUserName())){
            throw new IllegalArgumentException("User already exists in catalog");
        }
        userCatalog.put(user.getUserName(), user);
    }

    private boolean isBookBorrowedBySomeUser(String isbn) {
        return borrowedBooks.containsKey(isbn);
    }


    public void borrowBook(User user, String isbn) {
        Book book = bookInventory.get(isbn);

        if(isBookBorrowedBySomeUser(isbn)) {
            throw new IllegalArgumentException("Book is already borrowed");
        }
        if(book == null){
            throw new IllegalArgumentException("Book not found");
        }

        borrowedBooks.put(isbn, user.getUserName());
        borrowedBookDetails.put(isbn, book);
        bookInventory.remove(isbn);
    }

    public void returnBook(User user, String isbn) {
        if( !user.getUserName().equals(borrowedBooks.get(isbn))){
            throw new IllegalArgumentException("book was not borrowed by this user");
        }
        Book book = getBookByISBNFromBorrowedBook(isbn);
        bookInventory.put(isbn, book);
        borrowedBooks.remove(isbn);
    }


    public User getUserByName(String userName) {
        return userCatalog.get(userName);
    }

    public void addBook(User user, Book book) {
        if(user.isPermittedToAddBook()){
            bookInventory.put(book.getISBN(), book);
        } else {
            throw new PermissionDeniedException("You are not authorized to add book");
        }
    }

    public String getBorrowerNameByISBN(String isbn) {
        return borrowedBooks.get(isbn);
    }

    public Map<String, Book> viewAvailableBooks() {
        return Collections.unmodifiableMap(new HashMap<>(bookInventory));
    }
    public Book getBookByISBNFromBorrowedBook(String isbn) {
        return borrowedBookDetails.get(isbn);
    }

    public Book getBookByISBN(String isbn) {
        return bookInventory.get(isbn);
    }

}
