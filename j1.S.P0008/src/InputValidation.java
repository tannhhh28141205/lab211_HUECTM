/*
 * Input Validation for Letter and Character Count
 */

import java.util.Scanner;

public class InputValidation {

    private static final Scanner sc = new Scanner(System.in);

    public static String getString(String msg) {
        while (true) {
            System.out.println(msg);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("invalid, input cannot empty");
            } else {
                return input;
            }

        }
    }
}
