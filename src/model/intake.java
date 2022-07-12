package model;

import java.time.LocalDate;

public class intake {
    private String intakeID;
    private LocalDate startDate;
    private String intakecol;
    private String Description;
    private String courseID;


    public intake() {
    }

    public intake(String intakeID, LocalDate startDate, String intakecol, String description, String courseID) {
        this.setIntakeID(intakeID);
        this.setStartDate(startDate);
        this.setIntakecol(intakecol);
        setDescription(description);
        this.setCourseID(courseID);
    }

    public String getIntakeID() {
        return intakeID;
    }

    public void setIntakeID(String intakeID) {
        this.intakeID = intakeID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getIntakecol() {
        return intakecol;
    }

    public void setIntakecol(String intakecol) {
        this.intakecol = intakecol;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString() {
        return "intake{" +
                "intakeID='" + intakeID + '\'' +
                ", startDate=" + startDate +
                ", intakecol='" + intakecol + '\'' +
                ", Description='" + Description + '\'' +
                ", courseID='" + courseID + '\'' +
                '}';
    }
}
