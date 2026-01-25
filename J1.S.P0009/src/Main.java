
public class Main {

    public static void main(String[] args) {

        Fibonacci fb = new Fibonacci();

        // According to assignment: fixed 45 sequence
        int size = 45;

        fb.generateFibonacci(size);
        fb.displaySequence();
    }
}
