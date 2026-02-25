package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {

    private int id;
    private int taskType;
    private String name, date;
    private double planFrom, planTo;
    private String assignee, reviewer;

    private Date parseDate;

    public Task() {
    }

    public Task(String name, int taskType, String date, double planFrom, double planTo, String assignee, String reviewer) {
        this.name = name;
        this.taskType = taskType;
        this.setDate(date);
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
        validateTimeAssign();
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

    //setter
    public void setId(int id) {
        this.id = id;
    }

    public void setTaskType(int taskType) {
        if (taskType > 4 || taskType < 1) {
            throw new IllegalArgumentException("Error, that type not exist");
        }
        this.taskType = taskType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;

        try {
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            df.setLenient(false);
            this.parseDate = df.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format (dd-MM-yyyy)");
        }

    }

    public Date getParseDate() {
        return parseDate;
    }

    public void setPlanFrom(double planFrom) {
        if (!isTimeValid(planFrom)) {
            throw new IllegalArgumentException("error, the time from not available");
        }
        this.planFrom = planFrom;
    }

    public void setPlanTo(double planTo) {
        if (!isTimeValid(planTo)) {
            throw new IllegalArgumentException("error, the time to not available");
        }
        this.planTo = planTo;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    private String getTaskTypeString() {
        String res = "";

        switch (this.getTaskType()) {
            case 1 ->
                res = "Code";
            case 2 ->
                res = "Test";
            case 3 ->
                res = "Design";
            case 4 ->
                res = "Review";
        }
        return res;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s %.0f %s %s", id, name, getTaskTypeString(),
                date, (planTo - planFrom), assignee, reviewer);
    }

    public void validateTimeAssign() {
        if (planFrom >= planTo) {
            throw new IllegalArgumentException("error, the time assign not available");
        }
    }

    private boolean isTimeValid(double time) {
        return time <= 17.5 && time >= 8.0 && (time * 10) % 5 == 0;
    }
}
