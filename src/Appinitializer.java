import db.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class Appinitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        DBConnection object =DBConnection.getInstance();
        Connection connection= object.getConnection();
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/dashboard.fxml"))));
        primaryStage.show();
        primaryStage.setTitle("Dash Board");
    }
}
