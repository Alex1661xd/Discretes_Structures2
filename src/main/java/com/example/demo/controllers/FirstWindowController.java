package com.example.demo.controllers;

import com.example.demo.Classes.DataReader;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class FirstWindowController implements Initializable {

    public Pane pane;
    public ChoiceBox graph;
    public TextField nickname;
    public Button play;
    public ImageView image;

    private DataReader reader;
    public void OnPressedPlay(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reader=new DataReader();
        image.setImage(reader.imageFirstWindow());
    }
}
