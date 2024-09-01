package org.vaishnavii;

public class Library {

    String name;

    public Library(String name) {

        if(name == null) {
            throw new IllegalArgumentException("Library Name Should not be null");
        }
        this.name = name;
    }
}
