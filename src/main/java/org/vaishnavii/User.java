package org.vaishnavii;

public class User {

    private String userName;
    private Role role;

    public User(String userName, Role role) {
        this.userName = userName;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isPermittedToAddBook() {
        return role == Role.LIBRARIAN;
    }


}
