import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Book> books;
    private HashMap<String, Integer> genreCount;
    private int capacity;
    public Library() {
        this.books = new ArrayList<>();
        this.genreCount = new HashMap<>();
        this.capacity = 10;
    }

    public int getCapacity() {
        return this.capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int countBooks() {
        return this.books.size();
    }
    public void addBook(Book book) {
        if (!isAtCapacity()) {
            books.add(book);
            updateGenreCount();
        }
    }
    public Boolean removeBook(Book book) {
//        if (this.books.contains(book)) {
//            this.books.remove(book);
//        }
        Boolean result = this.books.remove(book);
        updateGenreCount();
        return result;
    }
    public Boolean isAtCapacity() {
        return this.books.size() == this.capacity;
    }
    public int getGenreCount(String genre) {
        return this.genreCount.get(genre);
    }
    private void updateGenreCount() {
        this.genreCount = new HashMap<>();
        for (Book book : books) {
            if(genreCount.containsKey(book.getGenre())) {
                genreCount.replace(book.getGenre(), genreCount.get(book.getGenre()) + 1);
            } else {
                genreCount.put(book.getGenre(), 1);
            }
        }
    }
}
