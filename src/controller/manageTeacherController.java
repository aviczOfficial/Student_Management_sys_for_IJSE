package controller;

import Util.CrudUtil;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Student;
import model.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class manageTeacherController {

    public JFXTextField txtContact;
    public JFXTextField txtAddress;
    public JFXTextField txtNic;
    public TableView tblTeacher;
    public TableColumn colTeacherID;
    public TableColumn colTeacherName;
    public TableColumn colNic;
    public TableColumn ColContact;
    public TableColumn colAddress;
    public TextField txtTeacherID;
    public JFXTextField txtTeacherName;

    public void initialize(){

        autoGenerateID();
        colTeacherID.setCellValueFactory(new PropertyValueFactory<>("TeacherID"));
        colTeacherName.setCellValueFactory(new PropertyValueFactory<>("TeacherName"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("Nic"));
        ColContact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));

        try {
            setTeachers(new teacherDBController().getAllTeachers());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void btnAdd(ActionEvent actionEvent) {
        Teacher c = new Teacher(
                txtTeacherID.getText(),
                txtTeacherName.getText(),
                txtNic.getText(),
                txtContact.getText(),
                txtAddress.getText()


        );
        try {
            if (teacherDBController.addTeacher(c))
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
            else
                new Alert(Alert.AlertType.WARNING, "Try Again..").show();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        autoGenerateID();

        txtTeacherName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtNic.clear();
        initialize();
    }

    public void btnUpdate(ActionEvent actionEvent) {
        Teacher  c = new Teacher(
                txtTeacherID.getText(),txtTeacherName.getText(),txtNic.getText(),txtContact.getText(),
                txtAddress.getText()
        );

        try{
            boolean isUpdated = CrudUtil.execute("UPDATE teacher SET name=? ,nic=?,contact=? ,address=?   WHERE Teacher_id=?",c.getName(),c.getName(),c.getNic(),c.getContact(),c.getAddress(),c.getTeacherId());
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }


        }catch (SQLException | ClassNotFoundException e){

        }


    }

    public void btnDelete(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (new teacherDBController().Deleteteacher(txtTeacherID.getText())) {
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }

        autoGenerateID();

        txtTeacherName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtNic.clear();
        initialize();
    }




    private void setTeachers(ArrayList< Teacher > teachers) {
        ObservableList<Teacher> obList = FXCollections.observableArrayList();
        teachers.forEach(e->{
            obList.add(
                    new Teacher(e.getTeacherId(),e.getName(),e.getNic(),e.getContact(),e.getAddress()));
        });
        tblTeacher.setItems(obList);
    }






    public void autoGenerateID() {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select Teacher_id from teacher order by Teacher_id  desc limit 1");
            boolean isExist = resultSet.next();
            if (isExist) {
                String olddID = resultSet.getString(1);
                int length = olddID.length();
                String id = olddID.substring(1, length);
                int intId = Integer.parseInt(id);
                intId = intId + 1;
                if (intId < 10) {
                    txtTeacherID.setText("T00" + intId);
                } else if (intId < 100) {
                    txtTeacherID.setText("T0" + intId);
                } else {
                    txtTeacherID.setText("T" + intId);
                }
            }
            else {
               txtTeacherID.setText("T001");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
