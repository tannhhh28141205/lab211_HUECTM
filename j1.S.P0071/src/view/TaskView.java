package view;

import java.util.List;
import java.util.Scanner;
import model.Task;

public class TaskView {

    private Scanner sc = new Scanner(System.in);

    public int menu() {

        System.out.println("========= Task program =========");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display Task");
        System.out.println("4. Exit");
        System.out.print("Please choice: ");

        return Integer.parseInt(sc.nextLine());
    }

    public String input(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void display(List<Task> list) {

        if (list.isEmpty()) {
            System.out.println("List empty.");
            return;
        }

        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-5s%-20s%-10s%-15s%-10s%-15s%-15s\n",
                "ID", "Name", "Type", "Date", "Time", "Assignee", "Reviewer");

        for (Task t : list) {
            System.out.printf("%-5d%-20s%-10s%-15s%-10.1f%-15s%-15s\n",
                    t.getId(),
                    t.getRequirementName(),
                    t.getTaskTypeName(),
                    t.getDate(),
                    t.getTime(),
                    t.getAssignee(),
                    t.getReviewer());
        }
    }
}