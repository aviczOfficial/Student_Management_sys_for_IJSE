package model;

public class Course {

    private String courseID;
    private String courseName;
    private Double cost;
    private String duration;
    private String subjectID;

    public Course() {
    }

    public Course(String courseID, String courseName, Double cost, String duration, String subjectID) {
        this.setCourseID(courseID);
        this.setCourseName(courseName);
        this.setCost(cost);
        this.setDuration(duration);
        this.setSubjectID(subjectID);
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", cost=" + cost +
                ", duration='" + duration + '\'' +
                ", subjectID='" + subjectID + '\'' +
                '}';
    }
}
