package com.example.demo.Classes;

import com.example.demo.controllers.GameController1;

public class setObject {
    GameController1 gc;

    public setObject(GameController1 gc) {
        this.gc = gc;
    }

    public void setOb(){
         gc.object[0]=new ObjectEnemy();
         gc.object[0].worldX=186;
         gc.object[0].worldY=75;

        gc.object[1]=new ObjectEnemy();
        gc.object[1].worldX=533;
        gc.object[1].worldY=127;

        gc.object[2]=new ObjectEnemy();
        gc.object[2].worldX=149;
        gc.object[2].worldY=312;

        gc.object[3]=new ObjectEnemy();
        gc.object[3].worldX=342;
        gc.object[3].worldY=410;

        gc.object[4]=new ObjectEnemy();
        gc.object[4].worldX=341;
        gc.object[4].worldY=223;

        gc.object[5]=new ObjectEnemy();
        gc.object[5].worldX=631;
        gc.object[5].worldY=316;

        gc.object[6]=new ObjectEnemy();
        gc.object[6].worldX=91;
        gc.object[6].worldY=456;

        gc.object[7]=new ObjectEnemy();
        gc.object[7].worldX=91;
        gc.object[7].worldY=168;

        gc.object[8]=new ObjectEnemy();
        gc.object[8].worldX=627;
        gc.object[8].worldY=24;

        gc.object[9]=new ObjectEnemy();
        gc.object[9].name="corona";
        gc.object[9].worldX=100;
        gc.object[9].worldY=100;

    }
}
