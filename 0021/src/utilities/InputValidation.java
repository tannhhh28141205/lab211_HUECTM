package utilities;


import java.util.Scanner;

public class InputValidation {

    public static String REGEX_ADD = "[YyNn]";
    public static String REGEX_DELETE_UPDATE = "[UuDd]";

    public static String inputString(String msg, String msgError, String regex) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            //check string user entered empty ==>tell user
            if (input.isEmpty()) {
                System.out.println("Invalid, input could not empty!");
            }//check input matches with format yet==> tell user
            else if (!regex.isEmpty()) {
                if (!input.matches(regex)) {
                    System.out.println(msgError);
                } else {
                    return input;
                }
            } else {
                return input;
            }
        }
    }

    public static int inputInteger(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                int input = Integer.parseInt(inputString("", "", ""));
                //check input invalid with range of data
                if (input < min || input > max) {
                    System.out.println("Invalid, input could be in the range");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid, input could be integer number.");
            }
        }
    }

}
