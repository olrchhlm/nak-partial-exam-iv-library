import java.util.ArrayList;

/*
 *  Annahmen:
 *  
 *  Grund für Codedopplung: Damit die Kohäsion in der Klasse Book möglichst groß ist, wurde sie in die Klassen Book und CompactDisc aufgeteilt.
 *                          Da sich beide Klassen ähneln, kommt es durch die Aufteilung zu einem hohen Anteil an dupliziertem Code.
 *                          Dies würde sich durch die Nutzung von Vererbung verhindern lassen.
 *                          
 *  Erhalt der Funktionalität: Die public-Variablen des Ausgansprojektes erlaubten es dem Nutzer Listen auf "null" zu setzen.
 *                             Da wir dies nicht als vorgesehene Funktionalität erachten, sondern als Folge des schlechten Programmierstils
 *                             und die "setter"-Methoden nicht in der Programmlogik benötigt werden, haben wir uns gegen eine Implementierung dieser entschlossen.
 *                             Dies führt außerdem zu einer erhöhten Sicherheit für die Anwendungslogik (Siehe Nullpointer-Exceptions in Libraray1).
 */
/**
 * The class Client is used to borrow books of a Library.
 * 
 * @author Finnegan Haack, Aman Mata, Ole Reichhelm
 * @version 20.09.2018
 */
public class Client {
    private String name;
    private String address;
    private final ArrayList<String> favoriteCategories = new ArrayList<>();
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();
    private final ArrayList<CompactDisc> borrowedCompactDiscs = new ArrayList<>();

    public Client(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public ArrayList<String> getFavoriteCategories() {
        return favoriteCategories;
    }
    
    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks; 
    }
    
    public ArrayList<CompactDisc> getBorrowedCompactDiscs() {
        return borrowedCompactDiscs; 
    }
    
    public void addToBorrowedBooks(Book book) {
        borrowedBooks.add(book);
    }
    
    public void removeFromBorrowedBooks(Book book) {
        borrowedBooks.remove(book);
    }
    
    public void addToBorrowedCompactDiscs(CompactDisc compactDisc) {
        borrowedCompactDiscs.add(compactDisc);
    }
    
    public void removeFromBorrowedCompactDiscs(CompactDisc compactDisc) {
        borrowedCompactDiscs.remove(compactDisc);
    }
    
    public void addToFavoriteCategories(String category) {
        favoriteCategories.add(category);
    }
    
    public void removeFromFavoriteCategories(String category) {
        favoriteCategories.remove(category);
    }
    
    public boolean isFavoriteCategory(String category) {
        return favoriteCategories.contains (category);
    }
    
    public void returnBook(String title) {
        boolean bookFound = false; 
        for (int i = 0; i < borrowedBooks.size() && !bookFound; i++) {
            if (title.equals(borrowedBooks.get(i).getTitle())) {
                borrowedBooks.remove(i);
                bookFound = true; 
            }
        }
    }

    public void returnCompactDisc(String title) {
        boolean compactDiscFound = false; 
        for (int i = 0; i < borrowedCompactDiscs.size() && !compactDiscFound; i++) {
            if (title.equals(borrowedCompactDiscs.get(i).getTitle())) {
                borrowedCompactDiscs.remove(i);
                compactDiscFound = true; 
            }
        }
    }

    public boolean hasBook(String title) {
        boolean hasBook = false;
        for (Book book: borrowedBooks) {
            if (book.getTitle() == title) {
                hasBook = true;
            }
        }
        return hasBook;
    }
}