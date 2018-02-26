package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main extends Application {

    private BufferedWriter writer;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));
        primaryStage.setTitle("Calculator");
        writer = new BufferedWriter(new FileWriter("result.txt"));

        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();

        primaryStage.setOnCloseRequest((e) -> {
            try {
                writer.write("");
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            primaryStage.close();

        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
