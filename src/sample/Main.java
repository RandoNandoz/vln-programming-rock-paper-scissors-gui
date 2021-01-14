package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        int screenSizeHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int screenSizeWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        //noinspection IntegerDivisionInFloatingPointContext
        primaryStage.setScene(new Scene(root, screenSizeWidth / 3, screenSizeHeight / 2));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
