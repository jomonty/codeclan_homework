public class Main {

    public static void main(String[] args) {
        Book dune = new Book("Dune", "Herbert", "Sci-Fi");
        Book dune2 = new Book("Children of Dune", "Herbert", "Sci-Fi");
        Library lib = new Library();
        lib.addBook(dune);
        lib.addBook(dune);
        lib.addBook(dune2);
        lib.removeBook(dune);
        lib.removeBook(dune);
        lib.removeBook(dune);
        System.out.println(lib.countBooks());

    }
}
