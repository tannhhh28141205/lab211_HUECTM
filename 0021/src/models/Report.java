package models;

public class Report {

    private int id;
    private String name, courseName;
    private int totalCourse;
private double sumScore;
private double avg;

    public double getSumScore() {
        return sumScore;
    }

    public void setSumScore(double sumScore) {
        this.sumScore = sumScore;
    }
    public Report() {
    }

    public Report(int id, String name, String courseName, int totalCourse, double sumScore) {
        this.id = id;
        this.name = name;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
        this.sumScore = sumScore;
    }

    public double getAvg() {
        return sumScore;
    }

    public void setAvg(double avg) {
        this.sumScore = avg;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    @Override
    public String toString() {
        return String.format("%-4d %-15s %-10s %-10d %-10f", getId(),getName(), getCourseName(),
                getTotalCourse(), getAvg());
        
        
    }

}
