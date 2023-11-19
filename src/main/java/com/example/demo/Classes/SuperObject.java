package com.example.demo.Classes;

import com.example.demo.controllers.GameController1;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class SuperObject {

    public boolean collision=false;

    public String name;
    public ArrayList<Image> enemy;

    public int worldX,worldY;
    private int characterNum = 0;
    private int characterCounter = 0;
    private int animationSpeed1 = 8;
    private int animationSpeed2=0;

    public void drawObjects(GraphicsContext graphic, GameController1 gc){
        animationSpeed2++;
        if(animationSpeed2>=3){
            characterCounter++;
            if (characterCounter > animationSpeed1) {
                characterNum = (characterNum + 1) % enemy.size();
                characterCounter = 0;
            }
            animationSpeed2=0;
        }
        graphic.drawImage(enemy.get(characterCounter),worldX,worldY,48,48);
    }
}
