
import java.util.Scanner;

public class Validation {

    private Scanner scanner;

    public Validation() {
        this.scanner = new Scanner(System.in);
    }

    public int getInt(String message, String firstError,
            String secondError, String thirdError, int min, int max) {
        while (true) {
            try {
                System.out.println(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty!");
                } else {
                    int number = Integer.parseInt(input);
                    if (number < min) {

                        System.out.println(firstError);
                    } else if (number > max) {
                        System.out.println(secondError);
                    } else {
                        return number;
                    }

                }

            } catch (Exception e) {
                System.out.println(thirdError);
            }
        }
    }

    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
