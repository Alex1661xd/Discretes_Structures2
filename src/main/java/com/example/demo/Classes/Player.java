package com.example.demo.Classes;

import com.example.demo.controllers.GameController1;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {
    private final GameController1 gC;
    private final KeyHandler keyH;
    private final DataReader lector;
    private List<List<Image>> imagesList;
    private int characterNum = 0;
    private int characterCounter = 0;
    private int tamañoP=48;
    private int animationSpeed1 = 8;
    private int animationSpeed2=0;


    public Player(GameController1 gC, KeyHandler keyH) {
        this.gC = gC;
        this.keyH = keyH;
        this.lector = new DataReader();
        setDefaultValues();
        initializeImagesList();
        coliArea=new Rectangle();
        coliArea.setX(19);
        coliArea.setY(32);
        coliArea.setWidth(30);
        coliArea.setHeight(32);
    }

    private void initializeImagesList() {
        imagesList = new ArrayList<>();
        imagesList.add(lector.readImageCP(1));  // Images for "right"
        imagesList.add(lector.readImageCP(2));  // Images for "left"/
    }

    public void setDefaultValues() {
        worldX = 51;
        worldY = 28;
        speed = 4;
        direction = "down";
    }

    public void update() {

    }

    public void draw(GraphicsContext g) {
            Image image = imagesList.get(0).get(0);
            g.drawImage(image, worldX, worldY, tamañoP, tamañoP);
    }

}
