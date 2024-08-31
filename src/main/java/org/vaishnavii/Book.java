package org.vaishnavii;

import java.time.Year;

public class Book{
    private String isbn;
    private String title;
    private String author;
    private Year publicationYear;

    public Book(String isbn, String title, String author, Year publicationYear) {



        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }


}