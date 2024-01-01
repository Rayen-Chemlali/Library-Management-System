package library;

public class LibraryCard {
    private static int cardCounter = 1;
    private int cardNumber;
    private Patron patron;

    public LibraryCard(Patron patron) {
        this.cardNumber = cardCounter++;
        this.patron = patron;
    }

    public int getCardNumber() {
        return cardNumber;
    }
}
