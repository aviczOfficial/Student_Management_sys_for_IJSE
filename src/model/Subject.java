package model;

public class Subject {

    private String subjectID;
    private String subjectName;
    private Double credit;
    private String teacherID;

    public Subject() {
    }

    public Subject(String subjectID, String subjectName, Double credit, String teacherID) {
        this.setSubjectID(subjectID);
        this.setSubjectName(subjectName);
        this.setCredit(credit);
        this.setTeacherID(teacherID);
    }


    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectID='" + subjectID + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", credit=" + credit +
                ", teacherID='" + teacherID + '\'' +
                '}';
    }
}
