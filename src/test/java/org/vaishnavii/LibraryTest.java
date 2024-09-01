package org.vaishnavii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LibraryTest {

    @Test
    public void testFailWithoutProperConstructor() {
        Library library = new Library("Vaishnavi");
        assertNotNull(library);
    }

}
