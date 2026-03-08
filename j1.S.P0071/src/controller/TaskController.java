package controller;

import model.TaskManager;
import view.TaskView;

public class TaskController {

    private TaskManager manager = new TaskManager();
    private TaskView view = new TaskView();

    public void run() {

        while (true) {

            int choice = view.menu();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    view.display(manager.getDataTasks());
                    break;
                case 4:
                    return;
                default:
                    view.showMessage("Invalid choice.");
            }
        }
    }

    private void addTask() {

        String name = view.input("Requirement Name: ");
        int type = Integer.parseInt(view.input("Task Type (1-4): "));
        String date = view.input("Date (dd-MM-yyyy): ");
        double from = Double.parseDouble(view.input("From: "));
        double to = Double.parseDouble(view.input("To: "));
        String assignee = view.input("Assignee: ");
        String reviewer = view.input("Reviewer: ");

        manager.addTask(name, type, date, from, to, assignee, reviewer);
        view.showMessage("Add successful.");
    }

    private void deleteTask() {

        int id = Integer.parseInt(view.input("ID: "));
        manager.deleteTask(id);
        view.showMessage("Delete successful.");
    }
}
