package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import Utility.InputValidation;

public class TaskManager {

    private ArrayList<Task> list = new ArrayList<>();
    private int idCounter = 1;

    public int addTask(String requirementName, int taskTypeId,
            String date, double planFrom, double planTo,
            String assignee, String reviewer) throws Exception {

        InputValidation.checkTaskType(taskTypeId);
        InputValidation.checkDate(date);
        InputValidation.checkTime(planFrom);
        InputValidation.checkTime(planTo);
        InputValidation.checkPlan(planFrom, planTo);

        Task task = new Task(idCounter++, taskTypeId,
                requirementName, date,
                planFrom, planTo,
                assignee, reviewer);

        list.add(task);
        return task.getId();
    }

    public void deleteTask(int id) throws Exception {

        Task found = null;

        for (Task t : list) {
            if (t.getId() == id) {
                found = t;
                break;
            }
        }

        if (found == null) {
            throw new Exception("Task not found.");
        }

        list.remove(found);
    }

    public ArrayList<Task> getDataTasks() {

        Collections.sort(list, Comparator.comparing(Task::getId));
        return list;
    }
}