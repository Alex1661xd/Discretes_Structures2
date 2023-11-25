package com.example.demo.Classes;

import com.example.demo.controllers.GameController1;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {

    private static Player player;
    private final GameController1 gC;
    private final KeyHandler keyH;
    private final DataReader lector;
    private List<List<Image>> imagesList;
    private int characterNum = 0;
    private int characterCounter = 0;
    private int tamañoP=48;
    private int animationSpeed1 = 8;
    private int animationSpeed2=0;

    private int vidas=3;
    private int energia=10;
    private String nameNenufar="V0";


    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public String getNameNenufar() {
        return nameNenufar;
    }

    public void setNameNenufar(String nameNenufar) {
        this.nameNenufar = nameNenufar;
    }

    private Player(GameController1 gC, KeyHandler keyH) {
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

    public static Player PlayerGetInstance(GameController1 gC,KeyHandler keyH){
        if(player==null){
            player=new Player(gC,keyH);
        }else{
            return player;
        }
        return player;
    }

    private void initializeImagesList() {
        imagesList = new ArrayList<>();
        imagesList.add(lector.readImageCP(1));  // Images for "right"
        imagesList.add(lector.readImageCP(3));//Images icons
        imagesList.add(lector.readImageCP(4)); //Images energy
    }

    public void setDefaultValues() {
        worldX = 51;
        worldY = 28;
        speed = 4;
        direction = "down";
    }

    public void draw(GraphicsContext g) {
        g.drawImage(imagesList.get(0).get(0), worldX, worldY, tamañoP, tamañoP);
        int x=15;
        int y=535;
        for (int i = 0; i < vidas; i++) {
            g.drawImage(imagesList.get(1).get(0), x, y, 28, 28);
            x+=28;
        }

        if(energia>0){
            g.drawImage(imagesList.get(2).get(energia),700,520,60,60);
        }



    }


}
