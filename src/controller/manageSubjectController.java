package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class manageSubjectController {
    public JFXTextField txtSubName;
    public JFXTextField txtDouble;
    public JFXTextField txtCredit;
    public TableView tblSubject;
    public TableColumn colSubjectID;
    public TableColumn colSubName;
    public TableColumn colCredit;
    public TableColumn ColTeacher;
    public TextField txtSubID;
    public JFXComboBox cmbTeacher;

    public void initialize(){

        autoGenerateID();
        colSubjectID.setCellValueFactory(new PropertyValueFactory<>("subject_id"));
        colSubName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCredit.setCellValueFactory(new PropertyValueFactory<>("credit"));
        ColTeacher.setCellValueFactory(new PropertyValueFactory<>("Teacher_id"));

        try {
            setSubjects(new studentDBController().getAllStudents());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void setSubjects(ArrayList<Student> customers) {
        ObservableList<Student> obList = FXCollections.observableArrayList();
        customers.forEach(e->{
            obList.add(
                    new Student(e.getStudentId(),e.getStudentName(),e.getEmail(),e.getContact(),e.getAddress(),e.getNic()));
        });
        tblStudent.setItems(obList);
    }

    public void autoGenerateID() {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select subject_id from subject order by Subject_id  desc limit 1");
            boolean isExist = resultSet.next();
            if (isExist) {
                String olddID = resultSet.getString(1);
                int length = olddID.length();
                String id = olddID.substring(1, length);
                int intId = Integer.parseInt(id);
                intId = intId + 1;
                if (intId < 10) {
                    txtSubID.setText("Sub00" + intId);
                } else if (intId < 100) {
                    txtSubID.setText("Sub0" + intId);
                } else {
                    txtSubID.setText("Sub" + intId);
                }
            }
            else {
                txtSubID.setText("Sub001");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void btnAdd(ActionEvent actionEvent) {
    }

    public void btnUpdate(ActionEvent actionEvent) {
    }

    public void btnDelete(ActionEvent actionEvent) {
    }
}
