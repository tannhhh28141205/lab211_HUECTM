package View;

import Controller.TaskManagement;
import Model.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ViewTask {

    public void run() {
        List<Task> listTask = new ArrayList<>();
        TaskManagement manage = new TaskManagement();
        manage.mock(listTask);

        while (true) {

            //Show menu
            showMenu();
            //Ask user enter option
            int option = inputOption();

            switch (option) {
                case 1 ->
                    addTaskView(listTask, manage);
                case 2 ->
                    deleteTaskView(listTask, manage);
                case 3 ->
                    displayAllTask(listTask);
                case 4 ->
                    System.exit(0);
            }

        }

    }

    private void showMenu() {
        System.out.println("========= Task program =========\n"
                + "1.	Add Task\n"
                + "2.	Delete task\n"
                + "3.	Display Task\n"
                + "4.	exit");
    }

    private <T> T inputWithRetry(Supplier<T> t) {
        while (true) {
            try {
                return t.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void addTaskView(List<Task> listTask, TaskManagement manage
    ) {
        System.out.println("------------Add Task---------------");
        Task t = new Task();
        String name = Utility.InputValidation.inputString("Requirement Name: ", "", "");
        t.setName(name);
        int taskType = Utility.InputValidation.inputInteger("Task Type: ", 1, 4);
        t.setTaskType(taskType);
        String date = Utility.InputValidation.inputDate("Date: ");
        t.setDate(date);

        inputWithRetry(() -> {
            double from = Utility.InputValidation.inputDouble("From: ", 0.0, 23.55);
            t.setPlanFrom(from);
            return from;
        });
        
        inputWithRetry(() -> {
            double to = Utility.InputValidation.inputDouble("To: ", 0.0, 23.55);
            t.setPlanTo(to);
            t.validateTimeAssign();
            return to;
        });

        String assignee = Utility.InputValidation.inputString("Assignee: ", "", "");
        t.setAssignee(assignee);
        String reviewer = Utility.InputValidation.inputString("Reviewer: ", "", "");
        t.setReviewer(reviewer);

        try {
            manage.addTask(listTask, t);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private void deleteTaskView(List<Task> listTask, TaskManagement manage) {
        System.out.println("---------Del Task----------");

        int index = Utility.InputValidation.inputInteger("ID: ", 0, 100);
        try {
            manage.deleteTask(listTask, index);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private void displayAllTask(List<Task> listTask) {
        if (listTask.isEmpty()) {
            System.out.println("That list empty!");
        } else {
            System.out.println("----------------------------------------- Task ---------------------------------------");
            System.out.printf("%s %s %s %s %s %s %s\n", "ID", "Name",
                    "Task Type", "Date", "Time", "Assignee", "Reviewer");
            for (Task temp : listTask) {
                System.out.println(temp);
            }

        }
    }

    private int inputOption() {
        return Utility.InputValidation.inputInteger("Enter option: ", 1, 4);
    }
}
