package Screens;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import ApiClient.CalendarApiClient;
import ApiClient.PostApiClient;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start (Stage stage){
        try {
            File file = new File("src/main/java/FXML/LogInScreen.fxml");
            InputStream stream = new FileInputStream(file);
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(stream);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Calendar App");
            stage.getIcons().add(new Image("plantLogo.png"));
            stage.setOnCloseRequest(event -> {
                stage.close();
                CalendarApiClient.getInstance().writeData();
                PostApiClient.getInstance().writeData();
                System.exit(0);
            });
            stage.show();
        } catch (Exception exception){}
    }

    public static void main (String[] args){
        launch(args);
    }
}