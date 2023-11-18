package com.example.demo.Classes;

import com.example.demo.controllers.GameController1;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class SuperObject {

    public boolean collision=false;

    public String name;
    public Image enemy;

    public int worldX,worldY;

    public void drawObjects(GraphicsContext graphic, GameController1 gc){
        graphic.drawImage(enemy,worldX,worldY,48,48);
    }
}
