package com.example.demo.Classes;

import com.example.demo.controllers.GameController1;

public class CollisionChecker {

    GameController1 gc;
    public CollisionChecker(GameController1 gc) {
        this.gc=gc;
    }

    public void checkTile(Entity entity){
        double entityLeftWorldX=entity.worldX+entity.coliArea.getX();
        double entityRightWorldX=entity.worldX+entity.coliArea.getX()+entity.coliArea.getWidth();
        double entityTopWorldY=entity.worldY+entity.coliArea.getY();
        double entityBottomWorldY=entity.worldY+entity.coliArea.getY()+entity.coliArea.getHeight();
        double entityLeftCol=entityLeftWorldX/48;
        double entityRightCol=entityRightWorldX/48;
        double entityTopRow=entityTopWorldY/48;
        double entityBottomRow=entityBottomWorldY/48;

        double tileNum1,tileNum2;
        switch (entity.direction){
            case "up":
                entityTopRow=(entityTopWorldY - entity.speed)/48;
                tileNum1=gc.backGround.mapBackNum[(int) entityLeftCol][(int) entityTopRow];
                tileNum2=gc.backGround.mapBackNum[(int) entityRightCol][(int)entityTopRow];
                if(gc.backGround.tile.get((int) tileNum1).collision || gc.backGround.tile.get((int) tileNum2).collision){
                    entity.collisionOn=true;
                }
                break;
            case "left":
                entityLeftCol=(entityLeftWorldX - entity.speed)/48;
                tileNum1=gc.backGround.mapBackNum[(int) entityLeftCol][(int) entityTopRow];
                tileNum2=gc.backGround.mapBackNum[(int) entityLeftCol][(int)entityBottomRow];
                if(gc.backGround.tile.get((int) tileNum1).collision || gc.backGround.tile.get((int) tileNum2).collision){
                    entity.collisionOn=true;
                }
                break;
            case "right":
                entityRightCol=(entityRightWorldX + entity.speed)/48;
                tileNum1=gc.backGround.mapBackNum[(int) entityRightCol][(int) entityTopRow];
                tileNum2=gc.backGround.mapBackNum[(int) entityRightCol][(int)entityBottomRow];
                if(gc.backGround.tile.get((int) tileNum1).collision || gc.backGround.tile.get((int) tileNum2).collision){
                    entity.collisionOn=true;
                }
                break;
            case "down":
                entityBottomRow=(entityBottomWorldY + entity.speed)/48;
                tileNum1=gc.backGround.mapBackNum[(int) entityLeftCol][(int) entityBottomRow];
                tileNum2=gc.backGround.mapBackNum[(int) entityRightCol][(int)entityBottomRow];
                if(gc.backGround.tile.get((int) tileNum1).collision || gc.backGround.tile.get((int) tileNum2).collision){
                    entity.collisionOn=true;
                }
                break;
        }
    }
}
