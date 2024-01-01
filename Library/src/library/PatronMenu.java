package library;

import java.util.Scanner;

public class PatronMenu {
    private Patron patron;
    private Scanner scanner;

    public PatronMenu(Patron patron) {
        this.patron = patron;
        this.scanner = new Scanner(System.in);
    }

    public void displayPatronMenu() {
        int choice;
        do {
            System.out.println("Patron Menu:");
            System.out.println("1. Display Available Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Display Borrowed Books");
            System.out.println("5. Apply for Library Card");
            System.out.println("6. Exit");

            choice = scanner.nextInt();
            performPatronAction(choice);
        } while (choice != 6);
    }

    private void performPatronAction(int choice) {
        switch (choice) {
            case 1:
                displayAvailableBooks();
                break;
            case 2:
                borrowBook();
                break;
            case 3:
                returnBook();
                break;
            case 4:
                displayBorrowedBooks();
                break;
            case 5:
                applyForLibraryCard();
                break;
            case 6:
                System.out.println("Exiting Patron Menu.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void displayAvailableBooks() {
        System.out.println("Available Books:");
        LibraryManager.displayAvailableBooks();
    }

    private void borrowBook() {
        System.out.println("Enter the Book ID to borrow:");
        int bookID = scanner.nextInt();
        LibraryManager.borrowBook(patron, bookID);
    }

    private void returnBook() {
        System.out.println("Enter the Copy ID to return:");
        int copyID = scanner.nextInt();
        LibraryManager.returnBook(patron, copyID);
    }

    private void displayBorrowedBooks() {
        System.out.println(patron.getName() + "'s Borrowed Books:");
        for (BookCopy copy : patron.getBorrowedBooks()) {
            System.out.println(" - " + copy.getCopyID() + " of " + copy.getBook().getTitle());
        }
    }

    private void applyForLibraryCard() {
        if (patron.getLibraryCard() == null) {
            LibraryManager.issueLibraryCard(patron);
        } else {
            System.out.println("You already have a Library Card.");
        }
    }
}
