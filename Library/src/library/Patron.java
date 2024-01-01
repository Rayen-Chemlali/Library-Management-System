package library;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private int patronID;
    private String name;
    private LibraryCard libraryCard;
    private List<BookCopy> borrowedBooks;

    public Patron(int patronID, String name) {
        this.patronID = patronID;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
        this.libraryCard=new LibraryCard(this);
    }

    public int getPatronID() {
        return patronID;
    }

    public String getName() {
        return name;
    }

    public LibraryCard getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(LibraryCard libraryCard) {
        this.libraryCard = libraryCard;
    }

    public List<BookCopy> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(BookCopy copy) {
        borrowedBooks.add(copy);
    }

    public void returnBook(BookCopy copy) {
        borrowedBooks.remove(copy);
        copy.setAvailable(true);
    }
}
