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
 * The class Library is used to sotre books and compact discs and borrow them to Clients.
 * 
 * @author Finnegan Haack, Aman Mata, Ole Reichhelm
 * @version 20.09.2018
 */
public class Library {
    private final ArrayList<Book> books = new ArrayList<>();
    private final ArrayList<CompactDisc> compactDiscs = new ArrayList<>();
    private final ArrayList<Client> clients = new ArrayList<>();

    public Library() {
    }
    
    public ArrayList<Book> getBooks() {
        return books;
    }
    
    public ArrayList<CompactDisc> getCompactDiscs() {
        return compactDiscs;
    }
    
    public ArrayList<Client> getClients() {
        return clients;
    }
    
    public void addBook(Book book) {
        books.add(book);
    }

    public void deleteBook(Book book) {
        books.remove (book);
        for (Client client : clients) {
            client.removeFromBorrowedBooks(book);
        }
    }

    public void addCompactDisc(CompactDisc compactDisc) {
        compactDiscs.add (compactDisc);
    }

    public void deleteCompactDisc(CompactDisc compactDisc) {
        books.remove (compactDisc);
        for (Client client : clients) {
            client.removeFromBorrowedCompactDiscs(compactDisc);
        }
    }

    public void addClientToLibrary(Client client) {
        clients.add(client);
    }
    
    public void addAndBorrowBook(Book book, Client client) {
        addBook(book);
        client.addToBorrowedBooks(book);
    }
    
    public void printListOfItems() {
        for (Book book: books){
            book.printBook();
        }
        for (CompactDisc compactDisc: compactDiscs){
            compactDisc.printCompactDisc();
        }
    }
    
    public ArrayList<String> bookBorrowedBy(String title) {
        ArrayList<String> listOfClients = new ArrayList<>();
        for (Client client: clients) {
            if (client.hasBook(title)) {
                listOfClients.add(client.getName());
            }
        }
        return listOfClients;
    }

    public ArrayList<Client> clientsWithMostBorrowedBooks() {
        int mostBorrowedBooks = 0; 
        ArrayList<Client> clientsWithMostBorrowedBooks = new ArrayList<>(); 
        
        for(Client client : clients){
            int borrowedBooks = client.getBorrowedBooks().size();
            if(borrowedBooks > mostBorrowedBooks){
                mostBorrowedBooks = borrowedBooks; 
            }
        }
        for(Client client : clients){
            if(client.getBorrowedBooks().size() == mostBorrowedBooks){
                clientsWithMostBorrowedBooks.add(client); 
            }
        }
        return clientsWithMostBorrowedBooks; 
    } 
}