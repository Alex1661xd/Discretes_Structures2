package com.example.demo.controllers;
import com.example.demo.Classes.*;
import com.example.demo.HelloApplication;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;


public class GameController1 implements Initializable, Runnable{


    public Canvas canvas;

    public GraphicsContext gc;

    public Pane pane;
    public DialogPane dialogPane;
    public Thread gThread;
    boolean flag=true;
    KeyHandler keyH;
    Player player;
    boolean flag1=true;
    public Background backGround;
    public setObject setObject;
    public SuperObject[] object;
    public CollisionChecker collisionChecker;

    public FirstWindowController firstWindow;
    int FPS=60;

    public GameController1() {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        canvas.setStyle("-fx-background-color: transparent;");
        gc=canvas.getGraphicsContext2D();
        keyH=new KeyHandler(canvas);
        canvas.setFocusTraversable(true);
        pane.setFocusTraversable(true);
        backGround= Background.BackgroundGetInstance(this,keyH);
        object=new SuperObject[10];
        setObject=new setObject(this);
        setObjects();
        collisionChecker=new CollisionChecker(this);
        player=Player.PlayerGetInstance(this,keyH);
        firstWindow=new FirstWindowController();
        startGameThread();

    }
    public void startGameThread(){
        gThread = new Thread(this);
        gThread.start();
    }

    public void setObjects(){
        setObject.setOb();
    }

    @Override
    public void run() {
        double interval= (double) 1000000000 /FPS;
        double delta=0;
        long lastTime=System.nanoTime();
        long currenTime;
        long timer=0;
        int drawCount=0;
        //hola
        while (gThread!=null){
            currenTime=System.nanoTime();
            delta+=(currenTime-lastTime)/interval;
            timer+=(currenTime-lastTime);
            lastTime=currenTime;

            if(delta>=1){
                paint();
                delta--;
                drawCount++;
            }
            if(timer>=1000000000){
                //System.out.println("FPS: "+drawCount);
                drawCount=0;
                timer=0;
            }
        }
    }

    public void paint(){
        GraphicsContext gc= canvas.getGraphicsContext2D();
        backGround.paint(gc);
        if(player.getVidas()==0){
            if (flag){
                GameOverController.getInstance().typeImage=0;
                Platform.runLater(() -> {
                    HelloApplication.showWindow("GameMaker",null,600,330);
                    HelloApplication.hideWindow((Stage)pane.getScene().getWindow());
                });
                gThread=null;
                flag=false;
            }
        }else if(player.getNameNenufar().equals(nameCorona())){
            if (flag1){
                GameOverController.getInstance().typeImage=1;
                Platform.runLater(() -> {
                    HelloApplication.showWindow("GameMaker",null,600,330);
                    HelloApplication.hideWindow((Stage)pane.getScene().getWindow());
                });
                gThread=null;
                flag1=false;
            }
        }

        for (int i = 0; i < object.length; i++) {
            if(object[i]!=null&&i!=9){
                object[i].drawObjects(gc,this);
            }
            if(i==9){
                object[i].drawCorona(gc,this);
            }
        }
        player.draw(gc);
    }

    public String nameCorona(){
        return Background.BackgroundGetInstance(null,null).searchTileCorona();
    }



    public void OpenWindow(ActionEvent actionEvent) {
        HelloApplication.showWindow("hello-view",null,320,320);
    }
}
