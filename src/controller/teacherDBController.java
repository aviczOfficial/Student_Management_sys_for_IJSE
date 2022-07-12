package controller;

import db.DBConnection;
import model.Student;
import model.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class teacherDBController {
    public static boolean addTeacher(Teacher c) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO teacher VALUES (?,?,?,?,?)");
        preparedStatement.setObject(1, c.getTeacherId());
        preparedStatement.setObject(2, c.getName());
        preparedStatement.setObject(3, c.getNic());
        preparedStatement.setObject(4, c.getContact());
        preparedStatement.setObject(5, c.getAddress());


        return preparedStatement.executeUpdate() > 0;
    }


    public boolean Deleteteacher(String id) throws SQLException, ClassNotFoundException {
        if (DBConnection.getInstance().getConnection().prepareStatement("DELETE FROM teacher WHERE Teacher_id='" + id + "'").executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Teacher> getAllTeachers() throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM teacher");
        ResultSet rst = stm.executeQuery();
        ArrayList<Teacher> St = new ArrayList<>();
        while (rst.next()) {
            St.add(new Teacher(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)




            ));
        }
        return St;
    }

}
