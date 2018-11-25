import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Die Test-Klasse testLibrary.
 *
 * @author  Haack, Mata, Reichhelm
 * @version 20.09.2018
 */
public class testLibrary
{
    public testLibrary() {
    }
    
    private Library library;
    
    @Before
    public void setUp() {
        library = new Library();
    }
    
    @Test
    public void testPrintListOfBooks() {
        Book book1 = new Book("Woyzeck", "Büchner");
        book1.addToKeywordList("langweilig");
        book1.addToKeywordList("nervig");
        book1.addToKeywordList("unnötig");
        
        Book book3 = new Book("Der Schimmerlreiter", "Storm");
        
        Book book2 = new Book("Faust", "Goethe");
        book2.addToKeywordList("unnötig");
        
        CompactDisc compactDisc1 = new CompactDisc("Thriller", "Michael Jackson");
        compactDisc1.addToKeywordList("fresh");
        compactDisc1.addToKeywordList("alt");
        
        CompactDisc compactDisc2 = new CompactDisc("500PS", "187er");
        
        library.addBook(book1);
        library.addBook(book3);
        library.addBook(book2);
        
        library.addCompactDisc(compactDisc1);
        library.addCompactDisc(compactDisc2);
        library.printListOfItems();
    }
    
    @Test
    public void testClientsWithMostBorrowedBooks() {
        Client client1 = new Client("Schokohase", "Addresse");
        Client client2 = new Client("Milka-Kuh", "Addresse");
        Client client3 = new Client("Goldbär", "Addresse");
        
        library.addClientToLibrary(client1);
        library.addClientToLibrary(client2);
        library.addClientToLibrary(client3);
        
        Book book1 = new Book("Woyzeck", "Büchner");
        Book book2 = new Book("Faust", "Goethe");
        Book book3 = new Book("Die Räuber", "Schiller");
        Book book4 = new Book("Der Schimmelreiter", "Storm");
        
        client1.addToBorrowedBooks(book1); 
        client1.addToBorrowedBooks(book2); 
        client1.addToBorrowedBooks(book3); 
        client1.addToBorrowedBooks(book4);
        
        client2.addToBorrowedBooks(book1);
        client3.addToBorrowedBooks(book1);
        
        ArrayList<Client> expectedClients= new ArrayList<>();
        expectedClients.add(client1);
        
        assertEquals(expectedClients, library.clientsWithMostBorrowedBooks()); 
    }
    
    
    @Test
    public void testClientsWithMostBorrowedBooksSameAmount() {
        Client client1 = new Client("Schokohase", "Addresse");
        Client client2 = new Client("Milka-Kuh", "Addresse");
        Client client3 = new Client("Goldbär", "Addresse");
        
        library.addClientToLibrary(client1);
        library.addClientToLibrary(client2);
        library.addClientToLibrary(client3);
        
        Book book1 = new Book("Woyzeck", "Büchner");
        Book book2 = new Book("Faust", "Goethe");
        Book book3 = new Book("Die Räuber", "Schiller");
        Book book4 = new Book("Der Schimmelreiter", "Storm");
        
        client1.addToBorrowedBooks(book1); 
        client1.addToBorrowedBooks(book2); 
        client1.addToBorrowedBooks(book3); 
        client1.addToBorrowedBooks(book4);
        
        client2.addToBorrowedBooks(book1);
        client2.addToBorrowedBooks(book2); 
        client2.addToBorrowedBooks(book3); 
        client2.addToBorrowedBooks(book4);
        client3.addToBorrowedBooks(book1);
        
        ArrayList<Client> expectedClients= new ArrayList<>();
        expectedClients.add(client1);
        expectedClients.add(client2);
        
        assertEquals(expectedClients, library.clientsWithMostBorrowedBooks()); 
    }
    
    @Test
    public void testClientsWithMostBorrowedBooksNoClients() {
        ArrayList<Client> expectedClients= new ArrayList<>();

        assertEquals(expectedClients, library.clientsWithMostBorrowedBooks()); 
    }
    
    @Test
    public void testClientsWithMostBorrowedBooksNoBooksBorrowed() {
        Client client1 = new Client("Schokohase", "Addresse");
        Client client2 = new Client("Milka-Kuh", "Addresse");
        Client client3 = new Client("Goldbär", "Addresse");
        
        library.addClientToLibrary(client1);
        library.addClientToLibrary(client2);
        library.addClientToLibrary(client3);
        
        ArrayList<Client> expectedClients= new ArrayList<>();
        expectedClients.add(client1);
        expectedClients.add(client2);
        expectedClients.add(client3);
        
        assertEquals(expectedClients, library.clientsWithMostBorrowedBooks()); 
    }
    
    @Test
    public void testBookBorrowedBy() {
        Client client1 = new Client("Schokohase", "Addresse");
        Client client2 = new Client("Milka-Kuh", "Addresse");
        
        Book book1 = new Book("Woyzeck", "Büchner");
        Book book2 = new Book("Faust", "Goethe");
        Book book3 = new Book("Die Räuber", "Schiller");
        Book book4 = new Book("Der Schimmelreiter", "Storm");
        
        library.addClientToLibrary(client1);
        library.addClientToLibrary(client2);
        
        client1.addToBorrowedBooks(book1); 
        client1.addToBorrowedBooks(book2); 
        client1.addToBorrowedBooks(book3); 
        client1.addToBorrowedBooks(book4);
        
        client2.addToBorrowedBooks(book1);
        client2.addToBorrowedBooks(book2); 
        client2.addToBorrowedBooks(book3); 
        client2.addToBorrowedBooks(book4);
        
        ArrayList<String> expectedClients= new ArrayList<>();
        expectedClients.add("Schokohase");
        expectedClients.add("Milka-Kuh");
        
        assertEquals(expectedClients, library.bookBorrowedBy("Woyzeck"));
    }
    
    @Test
    public void testBookBorrowedByNotBorrowed() {
        Client client1 = new Client("Schokohase", "Addresse");
        Client client2 = new Client("Milka-Kuh", "Addresse");
        
        
        library.addClientToLibrary(client1);
        library.addClientToLibrary(client2);
        
        ArrayList<String> expectedClients= new ArrayList<>();
        
        assertEquals(expectedClients, library.bookBorrowedBy("Woyzeck"));
    }
    
    @Test
    public void testBookBorrowedByNoClients() {
        ArrayList<String> expectedClients= new ArrayList<>();
        
        assertEquals(expectedClients, library.bookBorrowedBy("Woyzeck"));
    }
}

