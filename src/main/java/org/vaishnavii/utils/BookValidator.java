package org.vaishnavii.utils;

import org.vaishnavii.Book;
import org.vaishnavii.exceptions.BookNotFoundException;

public class BookValidator {
    public static void validateBookNotNull(Book book, String message) {
        if (book == null) {
            throw new BookNotFoundException(message);
        }
    }
}
