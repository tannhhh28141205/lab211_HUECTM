/*
 * Input Validation for Letter and Character Count
 */


import java.util.Scanner;

public class InputValidation 
{

    private static final Scanner sc = new Scanner(System.in);


    public static String getString(String msg) 
    {
        while (true) 
        {
            System.out.print(msg);
            String input = sc.nextLine().trim();

            if (input.isEmpty()) 
            {
                System.out.println("Input cannot be empty. Please try again.");
            } 
            else 
            {
                return input;
            }
        }
    }

}