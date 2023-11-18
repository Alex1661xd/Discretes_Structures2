package com.example.demo.controllers;
import com.example.demo.Classes.CollisionChecker;
import com.example.demo.Classes.KeyHandler;
import com.example.demo.Classes.Player;
import com.example.demo.Classes.Background;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.Pane;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import java.net.URL;
import java.util.ResourceBundle;


public class GameController1 implements Initializable, Runnable{


    public Canvas canvas;

    public GraphicsContext gc;

    public Pane pane;
    public DialogPane dialogPane;
    Thread gThread;

    KeyHandler keyH;

    Player player;

    public Background backGround;


    public CollisionChecker collisionChecker;
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
        backGround= new Background(this);
        collisionChecker=new CollisionChecker(this);
        player=new Player(this,keyH);
        startGameThread();
    }
    public void startGameThread(){
        gThread = new Thread(this);
        gThread.start();
    }

    @Override
    public void run() {
        double interval= (double) 1000000000 /FPS;
        double delta=0;
        long lastTime=System.nanoTime();
        long currenTime;
        long timer=0;
        int drawCount=0;

        while (gThread!=null){
            currenTime=System.nanoTime();
            delta+=(currenTime-lastTime)/interval;
            timer+=(currenTime-lastTime);
            lastTime=currenTime;

            if(delta>=1){
                update();
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

    public void update(){
        player.update();
    }

    public void paint(){
        GraphicsContext gc= canvas.getGraphicsContext2D();
        backGround.paint(gc);
        player.draw(gc);
    }

}
