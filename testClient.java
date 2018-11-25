

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse testClient.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class testClient
{
    private Client client;
    
    @Before
    public void setUp() {
        client = new Client("Schokohase", "Adresse");
    }
    
    @Test
    public void testHasBook() {
        Book book = new Book("Der Schimmelreiter", "Storm");
        client.addToBorrowedBooks(book);
        assertTrue(client.hasBook("Der Schimmelreiter")); 
    }
    
    @Test
    public void testHasBookNoBook() {
        assertFalse(client.hasBook("Der Schimmelreiter")); 
    }
    
    @Test
    public void returnBook() {
        Book book = new Book("Der Schimmelreiter", "Storm");
        client.addToBorrowedBooks(book);
        client.addToBorrowedBooks(book);
        client.returnBook("Der Schimmelreiter");
        assertEquals(1, client.getBorrowedBooks().size()); 
    }
    
    @Test
    public void returnBookNoBooks() {
        client.returnBook("Der Schimmelreiter");
    }
    
    @Test
    public void returnBookCheckCorrectBook() {
        Book book1 = new Book("Der Schimmelreiter", "Storm");
        Book book2 = new Book("Faust", "Goethe");
        client.addToBorrowedBooks(book1);
        client.addToBorrowedBooks(book2);
        client.returnBook("Der Schimmelreiter");
        
        assertTrue(client.getBorrowedBooks().contains(book2)); 
    }
}
