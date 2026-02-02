package Utility;

import java.util.Scanner;

public class InputValidation {



    /**
     * provide an integer number within the range
     *
     * @param msg
     * @param min
     * @param max are the range accept
     * @return a valid integer
     */
    public static int inputInteger(String msg, int min, int max) {

        while (true) {
            System.out.println(msg);
            String input = inputString("", "");
            //handle invalid number input from user
            try {
                int res = Integer.parseInt(input);

                if (res < min || res > max) {
                    System.out.println("Invalid, please enter within the range");
                } else {
                    return res;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid, please enter is an integer number");
            }
        }
    }

    public static String inputString(String msg, String REGEX) {
         Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Invalid, input cannot empty");
            } else {

                if (REGEX.isEmpty()) {
                    return input;
                } else {

                    if (!input.matches(REGEX)) {
                        System.out.println("Invalid, please enter valid data type.");
                    } else {
                        return input;
                    }
                }

            }

        }
    }

    public static double inputDouble(String msg, double min, double max) {

        while (true) {
            System.out.println(msg);
            String input = inputString("", "");
            //handle invalid number input from user
            try {
                double res = Double.parseDouble(input);

                if (res <= min || res >= max) {
                    System.out.println("Invalid, please enter within the range");
                } else {
                    return res;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid, please enter is an double number");
            }
        }
    }

}
