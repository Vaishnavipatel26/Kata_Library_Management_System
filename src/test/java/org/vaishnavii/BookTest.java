package org.vaishnavii;

import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    @Test
    public void throwExceptionWhenISBNisNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Book(null, "Clean Code", "Robert Cecil Martin", Year.of(2012)));
        assertEquals("ISBN should not be null or empty", exception.getMessage());
    }

    @Test
    public void throwExceptionWhenTitleIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Book("9780132350884", null, "Robert Cecil Martin", Year.of(2012)));
        assertEquals("title should not be null or empty", exception.getMessage());
    }

    @Test
    public void throwExceptionWhenAuthorIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Book("9780132350884", "Clean Code", "", Year.of(2012)));
        assertEquals("author should not be null or empty", exception.getMessage());
    }
}
