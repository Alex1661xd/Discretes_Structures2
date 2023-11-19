package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FirstW.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 700, 435);

        stage.setTitle("2D Adventure");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void showWindow(String fxml, Stage stage){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml+".fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 768, 576);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(stage==null) stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public static void hideWindow(Stage stage){
        stage.hide();
    }

    public static void main(String[] args) {
        launch();
    }
}
