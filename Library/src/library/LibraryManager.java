package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryManager {
    private static Map<Integer, Book> booksMap = new HashMap<>();
    private static List<Category> categories = new ArrayList<>();
    private static Map<Integer, Patron> patronsMap = new HashMap<>();
    private static int bookIdCounter = 1;
    private static int patronsIdCounter = 1;

    public static void addBook(String ISBN, String title, String author, Category category) {
        Book book = new Book(bookIdCounter++, ISBN, title, author, category);
        booksMap.put(book.getBookID(), book);
    }

    public static void removeBook(int bookID) {
        booksMap.remove(bookID);
    }

    public static void addCategory(Category category) {
        categories.add(category);
    }

    public static void removeCategory(Category category) {
        categories.remove(category);
    }

    public static List<Patron> getPatrons() {
        return new ArrayList<>(patronsMap.values());
    }
    public static Patron getPatron(int patronId)
    {
        return patronsMap.get(patronId);
    }

    public static void addPatron(String name) {
        Patron patron = new Patron(patronsIdCounter++, name);
        patronsMap.put(patron.hashCode(), patron);
    }

    public static void removePatron(Patron patron) {
        patronsMap.remove(patron.hashCode());
    }

    public static void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : booksMap.values()) {
            for (BookCopy copy : book.getCopies()) {
                if (copy.isAvailable()) {
                    System.out.println(book.getTitle() + " - Copy ID: " + copy.getCopyID());
                }
            }
        }
        System.out.println();
    }

    public static void displayCategories() {
        System.out.println("Categories:");
        for (Category category : categories) {
            System.out.println(category.getCategoryName());
        }
        System.out.println();
    }

    public static void displayBorrowedBooks() {
        System.out.println("Borrowed Books:");
        for (Patron patron : patronsMap.values()) {
            System.out.println(patron.getName() + "'s Borrowed Books:");
            for (BookCopy copy : patron.getBorrowedBooks()) {
                System.out.println(" - " + copy.getCopyID() + " of " + copy.getBook().getTitle());
            }
        }
        System.out.println();
    }

    public static void borrowBook(Patron patron, int bookID) {
        if (booksMap.containsKey(bookID)) {
            Book book = booksMap.get(bookID);
            BookCopy copy = book.borrowCopy();
            if (copy != null) {
                patron.borrowBook(copy);
                System.out.println(patron.getName() + " borrowed " + copy.getCopyID() + " of " + book.getTitle());
            } else {
                System.out.println("No available copies of " + book.getTitle() + " to borrow.");
            }
        } else {
            System.out.println("Book with ID " + bookID + " not found.");
        }
    }

    public static void returnBook(Patron patron, int copyID) {
        boolean bookReturned = false;
        for (BookCopy copy : patron.getBorrowedBooks()) {
            if (copy.getCopyID() == copyID) {
                Book book = copy.getBook();
                patron.returnBook(copy);
                System.out.println(patron.getName() + " returned " + copyID + " of " + book.getTitle());
                bookReturned = true;
                break;
            }
        }
        if (!bookReturned) {
            System.out.println(patron.getName() + " does not have this copy to return.");
        }
    }

    public static void issueLibraryCard(Patron patron) {
        LibraryCard libraryCard = new LibraryCard(patron);
        patron.setLibraryCard(libraryCard);
        System.out.println(patron.getName() + "'s Library Card Issued. Card Number: " + libraryCard.getCardNumber());
    }

    public static void displayPatronInfo(Patron patron) {
        System.out.println("Patron Information:");
        System.out.println("ID: " + patron.getPatronID());
        System.out.println("Name: " + patron.getName());
        if (patron.getLibraryCard() != null) {
            System.out.println("Library Card Number: " + patron.getLibraryCard().getCardNumber());
        } else {
            System.out.println("No Library Card Issued.");
        }
        System.out.println();
    }
    public static int getPatronsIdCounter()
    {
        return patronsIdCounter;
    }
    public static int getBookIdCounter()
    {
        return bookIdCounter;
    }

}
