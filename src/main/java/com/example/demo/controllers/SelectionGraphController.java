package com.example.demo.controllers;

import com.example.demo.Classes.Background;
import com.example.demo.Classes.Nenufar;
import com.example.demo.Classes.Player;
import com.example.demo.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SelectionGraphController {
    public TextField graph;
    public Button select;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        String nameVector=graph.getText();
        System.out.println(nameVector);
        Nenufar nenufar= Background.BackgroundGetInstance(null,null).searchTile(nameVector);
        if(nenufar!=null){
            int nenufarX=nenufar.getWorldX()-5;
            int nenufarY=nenufar.getWorldY()-20;
            Player.PlayerGetInstance(null,null).worldX=nenufarX;
            Player.PlayerGetInstance(null,null).worldY=nenufarY;
            HelloApplication.hideWindow((Stage)graph.getScene().getWindow());
        }else{
            System.out.println("Ocurrio un error");
        }

    }
}