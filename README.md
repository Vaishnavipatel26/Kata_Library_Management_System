# Kata_Library_Management_System
A simple library management system that allows users to perform basic operations such as adding books, borrowing books, returning books, and viewing available books.


## Table of Contents

- [Problem Statement](#problem-statement)
- [Requirements](#requirements)
- [Solution](#solution)
- [Features](#features)
- [Setup Instructions](#setup-instructions)
    - [Prerequisites](#prerequisites)
    - [Clone the Repository](#clone-the-repository)
    - [Import Project into IntelliJ IDEA](#import-project-into-intellij-idea)
    - [Build the Project](#build-the-project)
    - [Running Tests](#running-tests)

## Problem Statement

Create a simple library management system that allows users to perform basic operations such as adding books, borrowing books, returning books, and viewing available books.

### Requirements

- **Add Books**:
    - Users should be able to add new books to the library.
    - Each book should have a unique identifier (e.g., ISBN), title, author, and publication year.

- **Borrow Books**:
    - Users should be able to borrow a book from the library.
    - The system should ensure that the book is available before allowing it to be borrowed.
    - If the book is not available, the system should raise an appropriate error.

- **Return Books**:
    - Users should be able to return a borrowed book.
    - The system should update the availability of the book accordingly.

- **View Available Books**:
    - Users should be able to view a list of all available books in the library.

For a detailed problem statement and requirements, [click here](Problem%20Statement.md).

## Solution

This project follows TDD principles to solve the kata problem. The solution is built with small, incremental commits, ensuring that each feature is developed and tested in isolation, demonstrating effective TDD practices.

## Features

### User Management

- **addUser**:
    - Adds a new user to the library's user catalog.
    - Validates that the user is not null.
    - Throws an exception if the user already exists.

- **getUserByName**:
    - Retrieves a user from the library by their username.
    - Returns `null` if the user is not found.

### Book Management

- **addBook**:
    - Allows a user to add a book to the library's inventory.
    - Validates that the user is a librarian.
    - Ensures the book is not null.
    - Throws an exception if the user is unauthorized.

- **viewAvailableBooks**:
    - Returns a list of all books currently available in the library.
    - Ensures the list is unmodifiable.

- **getBookByISBN**:
    - Retrieves a book from the inventory using its ISBN.
    - Returns `null` if the book is not found.

### Borrowing and Returning Books

- **borrowBook**:
    - Allows a user to borrow a book from the library.
    - Validates that the book is not already borrowed.
    - Ensures the book exists in the inventory.
    - Throws an exception if the book is already borrowed.

- **returnBook**:
    - Allows a user to return a borrowed book to the library.
    - Validates that the book was borrowed by the same user.
    - Ensures the book is returned to the inventory.

- **getBorrowerNameByISBN**:
    - Retrieves the name of the user who borrowed a specific book.
    - Returns `null` if the book is not found.

- **getBookByISBNFromBorrowedBook**:
    - Retrieves details of a borrowed book using its ISBN.
    - Returns `null` if the book is not found.

## Setup Instructions

### Prerequisites

- **Java Development Kit (JDK)**: Ensure JDK 11 or later is installed on your machine.
- **Maven**: Ensure Maven is installed for managing dependencies and building the project.

### Clone the Repository

1. Open your terminal or command prompt.
2. Run the following command to clone the repository:

    ```bash
    git clone https://github.com/Vaishnavipatel26/Kata_Library_Management_System.git
    ```

3. Navigate into the project directory:

    ```bash
    cd project-name
    ```

### Import Project into IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Click on `File` > `Open...`.
3. Select the root directory of the project (where the `pom.xml` file is located).
4. Click `OK` to import the project.

### Build the Project

1. In IntelliJ IDEA, go to the Maven tool window (usually on the right side of the IDE).
2. Click on the `Reload All Maven Projects` button to ensure all dependencies are downloaded and the project is set up correctly.

### Running Tests

- To run the tests, navigate to the `LibraryTest` class and click on the run button.



