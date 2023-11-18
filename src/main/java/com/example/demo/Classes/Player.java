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
    private int animationSpeed1 = 10;
    private int animationSpeed2=0;


    public Player(GameController1 gC, KeyHandler keyH) {
        this.gC = gC;
        this.keyH = keyH;
        this.lector = new DataReader();
        setDefaultValues();
        initializeImagesList();
        coliArea=new Rectangle();
        coliArea.setX(22);
        coliArea.setY(35);
        coliArea.setWidth(32);
        coliArea.setHeight(32);
    }

    private void initializeImagesList() {
        imagesList = new ArrayList<>();
        imagesList.add(lector.readImageCP(1));  // Images for "right"
        imagesList.add(lector.readImageCP(2));  // Images for "left"
        imagesList.add(lector.readImageCP(3));  // Images for "kick"
        imagesList.add(lector.readImageCP(5));  // Images for "hurt"
        imagesList.add(lector.readImageCP(6)); // Images for "died"
    }

    public void setDefaultValues() {
        worldX = 340;
        worldY = 220;
        speed = 4;
        direction = "down";
    }

    public void update() {
        if (keyH.upPressed) {
            direction = "up";
        } else if (keyH.downPressed) {
            direction = "down";
        } else if (keyH.leftPressed) {
            direction = "left";
        } else if (keyH.rightPressed) {
            direction = "right";
        }
        collisionOn=false;
        gC.collisionChecker.checkTile(this);
        if(!collisionOn){
            switch (direction){
                case "up":
                    if(keyH.upPressed){
                        worldY -= speed;
                    }
                    break;
                case "down":
                    if(keyH.downPressed){
                        worldY += speed;
                    }
                    break;
                case "left":
                    if(keyH.leftPressed){
                        worldX -= speed;
                    }
                    break;
                case "right":
                    if(keyH.rightPressed){
                        worldX += speed;
                    }
                    break;
            }
        }


    }

    public void draw(GraphicsContext g) {
        if (!keyH.upPressed && !keyH.downPressed && !keyH.leftPressed && !keyH.rightPressed) {
            // Si ninguna tecla está presionada, mostrar la imagen quieta
            g.drawImage(imagesList.get(directionIndex(direction)).get(0), worldX, worldY, tamañoP, tamañoP);
        } else {
            // Si alguna tecla está presionada, realizar la animación normal
            Image image = imagesList.get(directionIndex(direction)).get(0);
            g.drawImage(image, worldX, worldY, tamañoP, tamañoP);
        }
    }


    private int directionIndex(String direction) {
        switch (direction) {
            case "up":
                return 0;
            case "left":
                return 1;
            case "down":
                return 0;
            // Add more cases as needed...
            default:
                return 0;
        }
    }
}
