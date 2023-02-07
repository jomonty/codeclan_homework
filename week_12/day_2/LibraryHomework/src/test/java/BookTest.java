import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    private Book book;
    @Before
    public void setup() {
        book = new Book("Dune", "Herbert", "Sci-fi");
    }

    @Test
    public void testGetSet() {
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setGenre("Genre");
        assertEquals("Title", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals("Genre", book.getGenre());
    }
}
