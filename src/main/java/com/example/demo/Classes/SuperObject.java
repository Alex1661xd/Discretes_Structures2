package com.example.demo.Classes;

import com.example.demo.controllers.GameController1;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Random;

public class SuperObject {

    public boolean collision=false;

    public String name;
    public ArrayList<Image> enemy;
    public Nenufar nenufarCorona=null;
    public int numero=6;

    public boolean flag=true;

    public Image corona;
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

    public void drawCorona(GraphicsContext graphic, GameController1 gc){
        Random random=new Random();
        if(flag){
            while(numero==6||numero==8||numero==19||numero==21||numero==31||numero==43||numero==48||numero==59||numero==63){
                numero=random.nextInt(49);
            }
            flag=false;
        }
            String nombre="V"+numero;
            Nenufar nenufar=Background.BackgroundGetInstance(null,null).searchTile(nombre);
            nenufarCorona=nenufar;
            nenufar.corona=true;
            gc.object[9].worldX=nenufar.WorldX;
            gc.object[9].worldY=nenufar.WorldY;
            graphic.drawImage(corona,nenufar.WorldX+8,nenufar.WorldY-2,40,40);
    }
}
