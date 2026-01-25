
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Validation valid = new Validation();
        int n = valid.getInt("Enter number of elements:",
                "Number must be greater than 0!",
                "Number  is too large!",
                " Please enter a valid integer!",
                1, 1000);
        BubbleSort bs = new BubbleSort(n);
        bs.randomElement();
        System.out.println("Unsorted  array:");
        bs.display();
        bs.sort();
        System.out.println("Sorted array");
        bs.display();

    }
}
