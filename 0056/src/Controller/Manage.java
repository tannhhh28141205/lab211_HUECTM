package Controller;

import Model.*;
import java.util.Date;
import java.util.List;

public class Manage {

    //Add Worker
    public void addWorker(List<Worker> listWorker, String id, String name, int age, double salary, String location) {
        if (findWorkerById(listWorker, id) != -1) {
            throw new IllegalArgumentException("That id duplicated!");
        }
        listWorker.add(new Worker(id, name, age, salary, location));
    }

    //check duplicate for code/id
    int findWorkerById(List<Worker> listWorker, String code) {
        for (int i = 0; i < listWorker.size(); i++) {
            if (listWorker.get(i).getId().equalsIgnoreCase(code)) {
                return i;
            }
        }
        return -1;
    }

    public void validateWorkerByAction(List<Worker> listWorker, String id, int choice) {
        String action = inputStatus(choice);
        switch (action) {
            case "ADD":
                if (findWorkerById(listWorker, id) != -1) {
                    throw new IllegalArgumentException("That code duplicated");
                }
                break;
            case "UP":
                if (findWorkerById(listWorker, id) == -1) {
                    throw new IllegalArgumentException("Not foud worker");
                }
                break;
            case "DOWN":
                if (findWorkerById(listWorker, id) == -1) {
                    throw new IllegalArgumentException("Not foud worker");
                }
                break;
        }
    }

    //Change salary
    // thieu if else cho viec co tim thay code hay khong
    public void updateSalary(List<Worker> listWorker, List<HistorySalary> listHistory, String findCode, double changeSalary, int choice) {
        if (listWorker.isEmpty()) {
            throw new IllegalArgumentException("List worker is empty, cannot update");
        }

        int index = findWorkerById(listWorker, findCode);

        if (index == -1) {
            throw new IllegalArgumentException("Invalid, cannot find worker with ID");
        }

        Worker worker = listWorker.get(index);
        String status = inputStatus(choice);
        double finalSalary = handleSalary(worker.getSalary(), changeSalary, status);
        worker.setSalary(finalSalary);

        listHistory.add(new HistorySalary(status, new Date(), worker));

    }

    double handleSalary(double currSalary, double changeSalary, String status) {
        double finalSalary = 0.0;

        if (status.equals("UP")) {
            if (currSalary + changeSalary > Double.MAX_VALUE) {
                throw new IllegalArgumentException("Invalid, salary cannot update with that change salary");
            }
            finalSalary = currSalary + changeSalary;

        } else {
            if (currSalary - changeSalary < 0) {
                throw new IllegalArgumentException("Invalid, salary cannot update with that change salary");
            }
            finalSalary = currSalary - changeSalary;
        }
        return finalSalary;
    }

    String inputStatus(int choice) {
        String status = "";
        switch (choice) {
            case 1:
                status = "ADD";
                break;
            case 2:
                status = "UP";
                break;
            case 3:
                status = "DOWN";
                break;

        }
        return status;
    }

}
