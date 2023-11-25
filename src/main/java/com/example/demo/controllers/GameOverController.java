package com.example.demo.controllers;

import com.example.demo.Classes.DataReader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class GameOverController implements Initializable {

    public ImageView image;

    public int typeImage;
    private DataReader reader;

    private static GameOverController gameOver;

    private GameOverController() {
    }

    public static GameOverController getInstance(){
        if(gameOver==null){
            gameOver=new GameOverController();
        }else{
            return gameOver;
        }
        return null;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reader=new DataReader();
        image.setImage(reader.imageGameOver(typeImage));
    }
}
