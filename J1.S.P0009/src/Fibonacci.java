

public class Fibonacci {

    private long[] arr;

    // Create fibonacci array
    public void generateFibonacci(int size) {
        arr = new long[size];
        generateByRecursion(0);
    }

    // Recursive method
    private void generateByRecursion(int index) {

        if (index == 0 || index == 1) {
            arr[index] = index;
        } else {
            arr[index] = arr[index - 1] + arr[index - 2];
        }

        if (index == arr.length - 1) {
            return;
        }

        generateByRecursion(index + 1);
    }

    // Display result
    public void displaySequence() {
        System.out.println("The 45 sequence fibonacci:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
