package models;

public class Enrollment {

    private int id;
    private String name;
    private int semeter, courseId;
    private double score;
    public Enrollment() {
    }



    public Enrollment(int id, String name, int semeter, int courseId, double score) {
        this.id = id;
        this.name = name;
        this.semeter = semeter;
        this.courseId = courseId;
        this.score = score;
    }

    //GETTER
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSemeter() {
        return semeter;
    }

    public int getCourseName() {
        return courseId;
    }

    public String getCourseNameString() {
        String res = null;
        switch (this.getCourseName()) {
            case 1 ->
                res = "Java";
            case 2 ->
                res = ".Net";
            case 3 ->
                res = "C/C++";
        }
        return res;
    }

    //SETTER
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemeter(int semeter) {
        if (semeter > 9) {
            throw new IllegalArgumentException("Error, only have 9 semester");
        }
        this.semeter = semeter;

    }

    public void setCourseName(int courseId) {
        if(courseId> 3){
            throw new IllegalArgumentException("Error, only have 3 courses");
        }
        this.courseId = courseId;

    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("%-10d %-13s %-13d %-10s %-10f",
                getId(), getName(), getSemeter(), getCourseNameString(), getScore());
    }

}
