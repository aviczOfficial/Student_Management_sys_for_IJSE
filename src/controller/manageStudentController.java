package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class manageStudentController {
    public JFXTextField txtStudentName;
    public Label lblStID;
    public JFXTextField txtEmail;
    public JFXTextField txtContact;
    public JFXTextField txtAddress;
    public JFXTextField txtNic;
    public TextField txtStId;

    public void initialize(){

        autoGenerateID();
    }

    public void btnAdd(ActionEvent actionEvent) {
        Student c = new Student(
                lblStID.getText(),
                txtStudentName.getText(),
                txtEmail.getText(),
                txtContact.getText(),
                txtAddress.getText(),
                txtNic.getText()

        );
        try {
            if (studentDBController.addStudent(c))
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
            else
                new Alert(Alert.AlertType.WARNING, "Try Again..").show();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        autoGenerateID();
        txtStudentName.clear();
        txtAddress.clear();
        txtAddress.clear();
        txtContact.clear();
        txtEmail.clear();


    }

    public void btnUpdate(ActionEvent actionEvent) {
    }

    public void btnDelete(ActionEvent actionEvent) {
    }

    public void autoGenerateID() {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select Student_id from student order by Student_id  desc limit 1");
            boolean isExist = resultSet.next();
            if (isExist) {
                String olddID = resultSet.getString(1);
                int length = olddID.length();
                String id = olddID.substring(1, length);
                int intId = Integer.parseInt(id);
                intId = intId + 1;
                if (intId < 10) {
                    txtStId.setText("S00" + intId);
                } else if (intId < 100) {
                    txtStId.setText("S0" + intId);
                } else {
                    txtStId.setText("S" + intId);
                }
            }
            else {
               txtStId.setText("S001");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
