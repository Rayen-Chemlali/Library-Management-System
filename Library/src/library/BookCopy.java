package library;

public class BookCopy {
    private int copyID;
    private boolean available;
    private Book book;

    public BookCopy(Book book) {
        this.copyID = book.getCopies().size() + 1;
        this.available = true;
        this.book = book;
    }

    public int getCopyID() {
        return copyID;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Book getBook() {
        return book;
    }
}
