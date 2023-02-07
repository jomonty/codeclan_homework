import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    private Library lib;
    private Book book;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;
    @Before
    public void setup() {
        lib = new Library();
        book = new Book("Dune", "Herbert", "Sci-Fi");
        book2 = new Book("Dune Messiah", "Herbert", "Sci-Fi");
        book3 = new Book("Children of Dune", "Herbert", "Sci-Fi");
        book4 = new Book("Return of the King", "Tolkien", "Fantasy");
        book5 = new Book("Shutter Island", "Lehane", "Thriller");
    }

    @Test
    public void testGetSet() {
        lib.setCapacity(10);
        assertEquals(10, lib.getCapacity());
    }
    @Test
    public void libCanCountBooks() {
        assertEquals(0, lib.countBooks());
    }
    @Test
    public void libCanAddBook() {
        lib.addBook(book);
        assertEquals(1, lib.countBooks());
    }
    @Test
    public void libCanRemoveBook() {
        lib.addBook(book);
        lib.removeBook(book);
        assertEquals(0, lib.countBooks());
    }
    @Test
    public void isLibFull() {
        lib.addBook(book);
        assertEquals(false, lib.isAtCapacity());
        lib.setCapacity(1);
        assertEquals(true, lib.isAtCapacity());
    }
    @Test
    public void libWontAddBookWhenFull() {
        lib.setCapacity(1);
        lib.addBook(book);
        lib.addBook(book);
        assertEquals(1, lib.countBooks());
    }
    @Test
    public void libCanReturnGenreCounts() {
        lib.addBook(book);
        lib.addBook(book2);
        lib.addBook(book3);
        lib.addBook(book4);
        lib.addBook(book5);
        assertEquals(3, lib.getGenreCount("Sci-Fi"));
        assertEquals(1, lib.getGenreCount("Fantasy"));
        assertEquals(1, lib.getGenreCount("Thriller"));
    }
}
