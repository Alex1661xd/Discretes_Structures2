package com.example.demo.controllers;

import com.example.demo.Classes.Background;
import com.example.demo.Classes.Nenufar;
import com.example.demo.Classes.Player;
import com.example.demo.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectionGraphController implements Initializable {
    public TextField graph;
    public Button select;
    public Label options;
    public Canvas nenufarImage;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        String nameVector=graph.getText();
        System.out.println(nameVector);
        Nenufar nenufar= Background.BackgroundGetInstance(null,null).searchTile(nameVector);
        if(nenufar!=null){
            Player.PlayerGetInstance(null,null).setNameNenufar(nenufar.name);
            int nenufarX=nenufar.getWorldX()+3;
            int nenufarY=nenufar.getWorldY()-20;
            Player.PlayerGetInstance(null,null).worldX=nenufarX;
            Player.PlayerGetInstance(null,null).worldY=nenufarY;
            HelloApplication.hideWindow((Stage)graph.getScene().getWindow());
        }else{
            System.out.println("Ocurrio un error");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String options1=GraphsController.getInstance().showConnections(Player.PlayerGetInstance(null,null).getNameNenufar());
        options.setText(options1);
        nenufarImage.getGraphicsContext2D().drawImage();
    }
}