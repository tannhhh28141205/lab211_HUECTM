package View;

import Model.*;
import java.util.List;
import Controller.Manage;

public class View_Worker {

    public void showMenu() {
        System.out.println("======== Worker Management =========\n"
                + "	Add Worker\n"
                + "	Up salary\n"
                + "	Down salary\n"
                + "	Display Information salary\n"
                + "	Exit");
    }

    public void addWorker(List<Worker> listWorker, Manage manage) {
        try {
            String id = Utility.InputValidation.inputString("Enter Code: ", "[A-Za-z0-9 ]+");
            manage.validateWorkerByAction(listWorker, id, 1);
            
            String name = Utility.InputValidation.inputString("Enter Name: ", "[A-Za-z0-9 ]+");
            
            int age = Utility.InputValidation.inputInteger("Enter Age: ", 18, 50);
            
            double salary = Utility.InputValidation.inputDouble("Enter Salary", 0, Double.MAX_VALUE);
            
            String location = Utility.InputValidation.inputString("Enter work location: ", "[A-Za-z0-9 ]+");
            
//            
//             Worker temp = new Worker();
//             temp.set
//             temp.setAge(age);
//            manage.addWorker(listWorker, temp);
            
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
    


    public void updateSalary(List<Worker> listWorker, List<HistorySalary> listHistory, Manage manage, int choice) {
        System.out.println("------- Up/Down Salary --------");
        try {
            
            String code = Utility.InputValidation.inputString("Enter Code: ", "[A-Za-z0-9 ]+");
            manage.validateWorkerByAction(listWorker, code, choice);
            double changeSalary = Utility.InputValidation.inputDouble("Enter Salary: ", 0, Double.MAX_VALUE);
            manage.updateSalary(listWorker, listHistory, code,changeSalary,choice);
            
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    public void displayAllSalaryHistory(List<HistorySalary> listHistory) {
        // Manage manage = new Manage();
        if (listHistory.isEmpty()) {
            System.out.println("History salary is empty!");
        } else {

            // manage.sortListHistory(listHistory);
            System.out.println("--------------------Display Information Salary-----------------------");
            System.out.printf("%s %s %s %s %s %s", "Code", "Name", "Age", "Salary", "Status",
                    "Date");
            for (HistorySalary temp : listHistory) {
                System.out.println(temp);
            }
        }
    }
    
    public int inputMenuChoice(){
        return Utility.InputValidation.inputInteger("Enter your choice", 1, 5);
    }

}
