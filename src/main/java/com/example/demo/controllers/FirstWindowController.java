package com.example.demo.controllers;

import com.example.demo.Classes.DataReader;
import com.example.demo.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FirstWindowController implements Initializable {

    public Pane pane;
    public ChoiceBox graph;
    public Button play;
    public ImageView image;
    public Region region;
    public TextField nickname;
    public GraphsController gpController;
    private DataReader reader;
    @FXML
    public void OnPressedPlay(ActionEvent actionEvent) {
        String nicknameText = nickname.getText();
        String typeGraph=null;
        try {
            typeGraph=graph.getValue().toString();
        }catch (Exception e){

        }
        if(!Objects.equals(nicknameText, "")&&typeGraph.equals("1. Graph Dijkstra, BFS, Lista")){
            gpController.setTypeGraph(1);
            gpController.addGraph();
            HelloApplication.showWindow("GameScene", null,768,576);
            HelloApplication.hideWindow((Stage)nickname.getScene().getWindow());
        }else if(!Objects.equals(nicknameText, "")&&typeGraph.equals("2. Graph Dijkstra , DFS, Matriz")){
            gpController.setTypeGraph(2);
            gpController.addGraph();
            HelloApplication.showWindow("GameScene", null,768,576);
            HelloApplication.hideWindow((Stage)nickname.getScene().getWindow());
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reader=new DataReader();
        gpController=GraphsController.getInstance();
        region.setStyle("-fx-background-color: #A0A0A0;");
        image.setImage(reader.imageFirstWindow());
        graph.getItems().add("1. Graph Dijkstra, BFS, Lista");
        graph.getItems().add("2. Graph Dijkstra , DFS, Matriz");
    }

}