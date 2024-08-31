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
}
