package org.vaishnavii;

public class User {

    private String userName;
    private String role;

    public User(String userName, String role) {
        this.userName = userName;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public String getRole() {
        return role;
    }

    public boolean isPermittedToAddBook() {
        return "Librarian".equalsIgnoreCase(role);
    }

}
