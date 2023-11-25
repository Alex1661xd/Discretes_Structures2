package com.example.demo.Classes;

public class Nenufar {

    public int WorldX,WorldY;
    public String name;

    public boolean enemy=false;

    public boolean corona=false;

    public Nenufar(int worldX, int worldY, String name) {
        WorldX = worldX;
        WorldY = worldY;
        this.name = name;
    }

    public int getWorldX() {
        return WorldX;
    }

    public int getWorldY() {
        return WorldY;
    }
}