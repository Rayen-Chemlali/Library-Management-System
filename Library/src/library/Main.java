package library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Library Management System!");
            System.out.println("Are you an admin or a patron? Enter 'admin' or 'patron' (or 'exit' to quit):");

            String userType = scanner.nextLine().toLowerCase();

            if ("admin".equals(userType)) {
                System.out.println("Enter your Admin ID:");
                String adminID = scanner.nextLine();
                System.out.println("Enter your name:");
                String adminName = scanner.nextLine();

                Admin admin = new Admin(adminID, adminName);

                Category fiction = new Category("Fiction");
                Category nonFiction = new Category("Non-Fiction");
                LibraryManager.addCategory(fiction);
                LibraryManager.addCategory(nonFiction);

                AdminMenu adminMenu = new AdminMenu(admin);
                adminMenu.displayAdminMenu();
            } else if ("patron".equals(userType)) {
                System.out.println("Enter your name:");
                String patronName = scanner.nextLine();
                LibraryManager.addPatron(patronName);
                Patron patron = LibraryManager.getPatron(LibraryManager.getPatronsIdCounter());
                PatronMenu patronMenu = new PatronMenu(patron);
                patronMenu.displayPatronMenu();
            } else if ("exit".equals(userType)) {
                System.out.println("Exiting the Library Management System.");
                break;
            } else {
                System.out.println("Invalid user type. Please try again.");
            }
        }

        scanner.close();
    }
}
