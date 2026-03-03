package Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InputValidation {

    // Validate task type (1 - 4)
    public static void checkTaskType(int type) throws Exception {
        if (type < 1 || type > 4) {
            throw new Exception("Task type must be from 1 to 4.");
        }
    }

    // Validate date format dd-MM-yyyy
    public static void checkDate(String date) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false);
            sdf.parse(date);
        } catch (ParseException e) {
            throw new Exception("Date must be format dd-MM-yyyy.");
        }
    }

    // Validate time range and step 0.5
    public static void checkTime(double time) throws Exception {
        if (time < 8.0 || time > 17.5 || (time * 10) % 5 != 0) {
            throw new Exception("Plan must be between 8.0 and 17.5 (step 0.5).");
        }
    }

    // Validate plan from < plan to
    public static void checkPlan(double from, double to) throws Exception {
        if (from >= to) {
            throw new Exception("Plan From must be less than Plan To.");
        }
    }
}