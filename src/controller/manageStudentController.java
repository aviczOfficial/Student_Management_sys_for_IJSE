package controller;

import Util.CrudUtil;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class manageStudentController {
    public JFXTextField txtStudentName;

    public JFXTextField txtEmail;
    public JFXTextField txtContact;
    public JFXTextField txtAddress;
    public JFXTextField txtNic;
    public TextField txtStId;
    public TableView tblStudent;
    public TableColumn colStID;
    public TableColumn colStName;
    public TableColumn colEmail;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colNic;

    public void initialize(){

        autoGenerateID();
        colStID.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        colStName.setCellValueFactory(new PropertyValueFactory<>("StudentName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("Nic"));
        try {
            setStudents(new studentDBController().getAllStudents());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void setStudents(ArrayList< Student > customers) {
        ObservableList<Student> obList = FXCollections.observableArrayList();
        customers.forEach(e->{
            obList.add(
                    new Student(e.getStudentId(),e.getStudentName(),e.getEmail(),e.getContact(),e.getAddress(),e.getNic()));
        });
        tblStudent.setItems(obList);
    }

    public void btnAdd(ActionEvent actionEvent) {
        Student c = new Student(
                txtStId.getText(),
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
        txtNic.clear();
        initialize();


    }

    public void btnUpdate(ActionEvent actionEvent) {
        Student  c = new Student(
                txtStId.getText(),txtStudentName.getText(),txtEmail.getText(),txtContact.getText(),
                txtAddress.getText(),txtNic.getText()
        );

        try{
            boolean isUpdated = CrudUtil.execute("UPDATE student SET Student_name=? ,email=?,contact=? ,address=? , nic=?  WHERE Student_id=?",c.getStudentName(),c.getEmail(),c.getContact(),c.getAddress(),c.getNic(),c.getStudentId());
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }


        }catch (SQLException | ClassNotFoundException e){

        }
        autoGenerateID();
        txtStudentName.clear();
        txtAddress.clear();
        txtAddress.clear();
        txtContact.clear();
        txtEmail.clear();
        txtNic.clear();
        initialize();



    }

    public void btnDelete(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (new studentDBController().DeleteStudent(txtStId.getText())) {
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }

        autoGenerateID();
        txtStudentName.clear();
        txtAddress.clear();
        txtAddress.clear();
        txtContact.clear();
        txtEmail.clear();
        txtNic.clear();
        initialize();
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
