import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {
    private Borrower borrower;
    private Library lib;
    private Book book;
    @Before
    public void setup() {
        book = new Book("Dune", "Herbert", "Sci-Fi");
        lib = new Library();
        borrower = new Borrower();
        lib.addBook(book);
    }
    @Test
    public void canCountBorrowedBooks() {
        assertEquals(0, borrower.countBooks());
    }
    @Test
    public void canBorrowBook() {
        borrower.borrowBook(lib, book);
        assertEquals(0, lib.countBooks());
        assertEquals(1, borrower.countBooks());
    }
    @Test
    public void canReturnBook() {
        borrower.borrowBook(lib, book);
        borrower.returnBook(lib, book);
        assertEquals(1, lib.countBooks());
        assertEquals(0, borrower.countBooks());
    }
}
