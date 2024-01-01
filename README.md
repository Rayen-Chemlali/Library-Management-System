# Library Management System

## Overview

The Library Management System is a console-based application designed to manage a library's operations. It allows users to interact as administrators or patrons, providing functionality such as adding/removing books, managing categories, organizing events, and handling patron-related tasks like borrowing and returning books.

## Project Structure

### 1. Main Class

- **Main.java:** The entry point of the application. Users can choose to log in as an admin or patron, perform actions, and exit the system.

### 2. Admin Classes

- **Admin.java:** Represents an admin user, providing methods for adding books, removing books, managing categories, and organizing events.
- **AdminMenu.java:** Handles the admin menu, allowing admins to perform various actions.

### 3. Library Classes

- **Book.java:** Represents a book, storing details such as title, author, and category. Manages copies and borrowing functionality.
- **BookCopy.java:** Represents a copy of a book, tracking availability and managing borrowing status.
- **Category.java:** Represents book categories.
- **Event.java:** Represents events organized by admins.

### 4. Patron Classes

- **Patron.java:** Represents a library patron, managing borrowed books and library card information.
- **PatronMenu.java:** Handles the patron menu, allowing patrons to interact with the library system.

### 5. Library Management Classes

- **LibraryManager.java:** Manages the core functionality of the library, including book and category management, patron interactions, and event organization.
- **LibraryCard.java:** Represents a library card issued to patrons.

## How to Run

1. Compile all Java files.
2. Run the `Main` class.
3. Follow the on-screen prompts to navigate through the Library Management System.

## Features

- **Admin Actions:** Add/Remove Books, Add/Remove Categories, Display Patron Information, Display Available Books, Display Categories, Organize Events.
- **Patron Actions:** Display Available Books, Borrow/Return Books, Display Borrowed Books, Apply for Library Card.
- **Book Management:** Add books with details, remove books, manage book copies and availability.
- **Category Management:** Add/Remove categories for organizing books.
- **Event Organization:** Admins can organize events with names and dates.
- **Library Card System:** Patrons can apply for library cards to borrow books.

## Notes

-This project is a simple console-based implementation, and additional features and improvements can be made for a more robust system.
