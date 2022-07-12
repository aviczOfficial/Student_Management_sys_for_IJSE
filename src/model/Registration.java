package model;

import java.time.LocalDate;

public class Registration {

    private String registrationID;
    private LocalDate regDate;
    private String studentID;
    private String intakeID;


    public Registration() {
    }

    public Registration(String registrationID, LocalDate regDate, String studentID, String intakeID) {
        this.setRegistrationID(registrationID);
        this.setRegDate(regDate);
        this.setStudentID(studentID);
        this.setIntakeID(intakeID);
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getIntakeID() {
        return intakeID;
    }

    public void setIntakeID(String intakeID) {
        this.intakeID = intakeID;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "registrationID='" + registrationID + '\'' +
                ", regDate=" + regDate +
                ", studentID='" + studentID + '\'' +
                ", intakeID='" + intakeID + '\'' +
                '}';
    }
}
