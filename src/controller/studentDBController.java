package controller;

import db.DBConnection;
import model.Student;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class studentDBController {
    public static boolean addStudent(Student c) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO student VALUES (?,?,?,?,?,?)");
        preparedStatement.setObject(1, c.getStudentId());
        preparedStatement.setObject(2, c.getStudentName());
        preparedStatement.setObject(3, c.getEmail());
        preparedStatement.setObject(4, c.getContact());
        preparedStatement.setObject(5, c.getAddress());
        preparedStatement.setObject(6, c.getNic());

        return preparedStatement.executeUpdate() > 0;
    }


    public boolean DeleteStudent(String id) throws SQLException, ClassNotFoundException {
        if (DBConnection.getInstance().getConnection().prepareStatement("DELETE FROM student WHERE Student_id='" + id + "'").executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }



}
