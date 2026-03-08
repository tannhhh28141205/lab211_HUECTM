package model;

public class Task {

    private int id;
    private int taskType;
    private String name, date;
    private double planFrom, planTo;
    private String assignee, reviewer;
    private Date parseDate;

    public Task(int id, int taskTypeId, String requirementName,
            String date, double planFrom, double planTo,
            String assignee, String reviewer) {

        this.id = id;
        this.taskTypeId = taskTypeId;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public int getTaskTypeId() {
        return taskTypeId;
    }

    public String getRequirementName() {
        return requirementName;
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
        switch (taskTypeId) {
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
