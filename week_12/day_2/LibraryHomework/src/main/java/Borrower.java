import java.util.ArrayList;

public class Borrower {
    private ArrayList<Book> books;
    public Borrower() {
        books = new ArrayList<>();
    }
    public int countBooks() {
        return this.books.size();
    }
    public void borrowBook(Library lib, Book book) {
        if (lib.removeBook(book)) {
            this.books.add(book);
        }
    }
    public void returnBook(Library lib, Book book) {
        if (this.books.remove(book)) {
            lib.addBook(book);
        }
    }
}
