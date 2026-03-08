package model;

public class Task {

    private int id;
    private int taskType;
    private String name, date;
    private double planFrom, planTo;
    private String assignee, reviewer;

    public Task(int id, int taskType, String name,
            String date, double planFrom, double planTo,
            String assignee, String reviewer) {

        this.id = id;
        this.taskType = taskType;
        this.name = name;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public int getTaskType() {
        return taskType;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public String getTaskTypeName() {
        switch (taskType) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            case 4:
                return "Review";
            default:
                return "";
        }
    }

    public double getTime() {
        return planTo - planFrom;
    }
}
