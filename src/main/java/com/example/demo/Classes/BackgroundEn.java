package com.example.demo.Classes;

import javafx.scene.image.Image;

public class BackgroundEn {

    private boolean collision=false;

    private Image background;

    private int worldX,worldY;

    private boolean isEnemyPosition=false;

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public Image getBackground() {
        return background;
    }

    public void setBackground(Image background) {
        this.background = background;
    }

    public int getWorldX() {
        return worldX;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }

    public boolean isEnemyPosition() {
        return isEnemyPosition;
    }

    public void setEnemyPosition(boolean enemyPosition) {
        isEnemyPosition = enemyPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;
}
