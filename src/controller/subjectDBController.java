package controller;

import db.DBConnection;
import model.Student;
import model.Subject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class subjectDBController {
    public static boolean addSubject(Subject c) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO subject VALUES (?,?,?,?)");
        preparedStatement.setObject(1, c.getSubjectID());
        preparedStatement.setObject(2, c.getSubjectName());
        preparedStatement.setObject(3, c.getCredit());
        preparedStatement.setObject(4, c.getTeacherID());


        return preparedStatement.executeUpdate() > 0;
    }


    public boolean DeleteSubject(String id) throws SQLException, ClassNotFoundException {
        if (DBConnection.getInstance().getConnection().prepareStatement("DELETE FROM subject WHERE subject_id='" + id + "'").executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Student> getAllSubjects() throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM subject");
        ResultSet rst = stm.executeQuery();
        ArrayList<Subject> St = new ArrayList<>();
        while (rst.next()) {
            St.add(new Subject(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getString(4)




            ));
        }
        return St;
    }
}
