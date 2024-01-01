package library;

public class Admin {
    private String adminID;
    private String name;

    public Admin(String adminID, String name) {
        this.adminID = adminID;
        this.name = name;
    }

    public String getAdminID() {
        return adminID;
    }

    public String getName() {
        return name;
    }

    public void addBook(String ISBN, String title, String author, Category category) {
        LibraryManager.addBook(ISBN, title, author, category);
        System.out.println("Book added successfully: " + title);
    }

    public void removeBook(int bookID) {
        LibraryManager.removeBook(bookID);
        System.out.println("Book removed successfully with ID: " + bookID);
    }

    public void addCategory(Category category) {
        LibraryManager.addCategory(category);
        System.out.println("Category added successfully: " + category.getCategoryName());
    }

    public void removeCategory(Category category) {
        LibraryManager.removeCategory(category);
        System.out.println("Category removed successfully: " + category.getCategoryName());
    }

    public void displayPatronInfo(Patron patron) {
        LibraryManager.displayPatronInfo(patron);
    }

    public void displayAvailableBooks() {
        LibraryManager.displayAvailableBooks();
    }

    public void displayCategories() {
        LibraryManager.displayCategories();
    }

    public void organizeEvent(String eventName, String eventDate) {
        Event event = new Event(eventName, eventDate);
        System.out.println("Event organized: " + event.getEventName() + " on " + event.getEventDate());
    }
}
