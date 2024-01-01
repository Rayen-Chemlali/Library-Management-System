package library;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private int bookID;
    private String ISBN;
    private String title;
    private String author;
    private Category category;
    private List<BookCopy> copies;

    public Book(int bookID, String ISBN, String title, String author, Category category) {
        this.bookID = bookID;
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.category = category;
        this.copies = new ArrayList<>();
        addCopy();
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    public List<BookCopy> getCopies() {
        return copies;
    }

    public void addCopy() {
        copies.add(new BookCopy(this));
    }

    public BookCopy borrowCopy() {
        for (BookCopy copy : copies) {
            if (copy.isAvailable()) {
                copy.setAvailable(false);
                return copy;
            }
        }
        // if there is no available copies
        return null;
    }
}
