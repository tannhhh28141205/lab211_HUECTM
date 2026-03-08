package Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InputValidation {

    public static void checkTaskType(int type) {
        if (type < 1 || type > 4) {
            System.out.println("Task type must be from 1 to 4.");
        }
    }

    public static void checkDate(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false);
            sdf.parse(date);
        } catch (ParseException e) {
            System.out.println("Date must be format dd-MM-yyyy.");
        }
    }

    public static void checkTime(double time) {
        if (time < 8.0 || time > 17.5 || (time * 10) % 5 != 0) {
            System.out.println("Plan must be between 8.0 and 17.5 (step 0.5).");
        }
    }

    public static void checkPlan(double from, double to) {
        if (from >= to) {
            System.out.println("Plan From must be less than Plan To.");
        }
    }
}
