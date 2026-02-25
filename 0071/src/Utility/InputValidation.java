package Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class InputValidation {

    public static String REGEX_DATE="^[\\d]{1,2}[\\-][\\d]{1,2}[\\-][\\d]{4}$";
    
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

    public static double inputDouble(String msg, double min, double max) {
        while (true) {
            System.out.print(msg);
            try {
                double input = Double.parseDouble(inputString("", "", ""));
                //check input invalid with range of data
                if (input < min || input > max) {
                    System.out.println("Invalid, input could be in the range");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid, input could be double number.");
            }
        }
    }
    
    /**
     * handle  input when user enter date data
     * @param msg notice to user 
     * @return  a date with string data type
     */
    public static String inputDate(String msg){
        SimpleDateFormat df= new SimpleDateFormat("dd-MM-yyyy");
        df.setLenient(false);
        while (true) {            
            System.out.print(msg);
            String input= inputString("", "Invalid, please enter valid date", 
                    REGEX_DATE);
            Date date= new Date();
            try {
                if(date.compareTo(df.parse(input)) >0){
                    System.out.println("Invalid, enter date within the future");
                }else{
                    return input;
                }
            } catch (ParseException ex) {
                System.out.println("Error, cannot prase that data");
            }
            
        }
    }


    
}
