package library;

import java.util.Scanner;

public class AdminMenu {
    private Admin admin;
    private Scanner scanner;

    public AdminMenu(Admin admin) {
        this.admin = admin;
        this.scanner = new Scanner(System.in);
    }

    public void displayAdminMenu() {
        int choice;
        do {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Add Category");
            System.out.println("4. Remove Category");
            System.out.println("5. Display Patron Information");
            System.out.println("6. Display Available Books");
            System.out.println("7. Display Categories");
            System.out.println("8. Organize Event");
            System.out.println("9. Exit");

            choice = scanner.nextInt();
            performAdminAction(choice);
        } while (choice != 9);
    }

    private void performAdminAction(int choice) {
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                removeBook();
                break;
            case 3:
                addCategory();
                break;
            case 4:
                removeCategory();
                break;
            case 5:
                displayPatronInfo();
                break;
            case 6:
                displayAvailableBooks();
                break;
            case 7:
                displayCategories();
                break;
            case 8:
                organizeEvent();
                break;
            case 9:
                System.out.println("Exiting Admin Menu.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void addBook() {
        System.out.println("Enter ISBN, Title, Author, and Category (separated by commas):");
        scanner.nextLine();
        String[] bookDetails = scanner.nextLine().split(",");
        String ISBN = bookDetails[0].trim();
        String title = bookDetails[1].trim();
        String author = bookDetails[2].trim();
        Category category = new Category(bookDetails[3].trim());
        admin.addBook(ISBN, title, author, category);
    }

    private void removeBook() {
        System.out.println("Enter the Book ID to remove:");
        int bookID = scanner.nextInt();
        admin.removeBook(bookID);
    }

    private void addCategory() {
        System.out.println("Enter Category Name:");
        scanner.nextLine();
        String categoryName = scanner.nextLine().trim();
        Category category = new Category(categoryName);
        admin.addCategory(category);
    }

    private void removeCategory() {
        System.out.println("Enter Category Name to remove:");
        scanner.nextLine();
        String categoryName = scanner.nextLine().trim();
        Category category = new Category(categoryName);
        admin.removeCategory(category);
    }

    private void displayPatronInfo() {
        System.out.println("Enter Patron ID to display information:");
        int patronID = scanner.nextInt();
        Patron patron = LibraryManager.getPatron(patronID);
        if (patron != null) {
            admin.displayPatronInfo(patron);
        } else {
            System.out.println("Patron not found with ID: " + patronID);
        }
    }

    private void displayAvailableBooks() {
        admin.displayAvailableBooks();
    }

    private void displayCategories() {
        admin.displayCategories();
    }

    private void organizeEvent() {
        System.out.println("Enter Event Name and Date (separated by a comma):");
        scanner.nextLine();
        String[] eventDetails = scanner.nextLine().split(",");
        String eventName = eventDetails[0].trim();
        String eventDate = eventDetails[1].trim();
        admin.organizeEvent(eventName, eventDate);
    }
}
