

import java.util.Scanner;

public class InputValidation {

    private static final Scanner sc = new Scanner(System.in);

    // Input integer in range (exclusive)
    public static int inputInteger(String msg, int min, int max) {
        while (true) {
            System.out.println(msg);
            String input = sc.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value > min && value < max) {
                    return value;
                } else {
                    System.out.println("Invalid, please enter number in range!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid, please enter an integer number!");
            }
        }
    }
}
