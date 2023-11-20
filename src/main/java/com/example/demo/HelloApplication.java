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
        FXMLLoader fxmlLoader =null;
        try {
             fxmlLoader=new FXMLLoader(getClass().getResource("GameScene.fxml"));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 768, 576);

        stage.setTitle("2D Adventure");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void showWindow(String fxml, Stage stage, int v1, int v2){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml+".fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), v1, v2);
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
