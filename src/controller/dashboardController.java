package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class dashboardController {
    public AnchorPane apDashboard;
    public Pane paneDashboard;

    public void btnManageStudent(ActionEvent actionEvent) throws IOException {
        paneDashboard.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/manageStudent.fxml"));
        paneDashboard.getChildren().add(parent);
    }

    public void btnManageTeacher(ActionEvent actionEvent) throws IOException {
        paneDashboard.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/manageTeacher.fxml"));
        paneDashboard.getChildren().add(parent);
    }

    public void btnManageSubject(ActionEvent actionEvent) {
    }

    public void btnManagePayment(ActionEvent actionEvent) {
    }

    public void btnRegistration(ActionEvent actionEvent) {
    }
}
