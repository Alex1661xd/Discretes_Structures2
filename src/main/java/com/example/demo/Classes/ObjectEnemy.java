package com.example.demo.Classes;

public class ObjectEnemy extends SuperObject{
    private DataReader reader;
    public ObjectEnemy() {
        reader=new DataReader();
        name="Enemy";
        enemy=reader.readImagenemy();
    }
}
