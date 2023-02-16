public class Runner {
    public static void main(String[] args) {
        for (int i=0; i<20; i++) {
            System.out.println(Math.floor(Math.random() * (100 - 5 + 1) + 5));
        }
    }
}
