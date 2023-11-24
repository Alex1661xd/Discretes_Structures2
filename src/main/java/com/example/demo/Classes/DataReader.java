package com.example.demo.Classes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.ArrayList;

public class DataReader {

    private File dataFolder;
    private File caracterP;
    private File enemy;
    private File background;

    private File iconos;

    public DataReader() {
        File projectDir = new File(System.getProperty("user.dir"));
        dataFolder = new File(projectDir + "/recursos");
        caracterP = new File(dataFolder + "/desencriptados/caracterPrincipal");
        enemy = new File(dataFolder + "/desencriptados/enemigos");
        background = new File(dataFolder + "/background");
        iconos = new File(dataFolder + "/Iconos");
    }


    public ArrayList<Image> readImageBackground(int option) {
        if (option == 1) {
            background = new File(dataFolder + "/background/agua");
        } else if (option == 2) {
            background = new File(dataFolder + "/background/bordes");
        } else if (option == 3) {
            background = new File(dataFolder + "/background/iconos");
        } else if (option == 4) {
            background = new File(dataFolder + "/background/pasto");
        } else if (option == 5) {
            background = new File(dataFolder + "/background/iconosSen");
        }
        File folder = background;
        File[] pngFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));
        ArrayList<Image> imageList = new ArrayList<>();

        if (pngFiles != null) {
            for (File pngFile : pngFiles) {
                Image image = new Image(pngFile.toURI().toString());
                imageList.add(image);
            }
        }

        return imageList;
    }

    public ArrayList<ImageView> readImageIcons() {
        File folder = iconos;
        File[] gifFiles = folder.listFiles((dir, name) -> name.endsWith(".png"));
        ArrayList<ImageView> imageViewList = new ArrayList<>();

        if (gifFiles != null) {
            for (File gifFile : gifFiles) {
                ImageView imageView = new ImageView(new Image(gifFile.toURI().toString()));
                imageViewList.add(imageView);
            }
        }

        return imageViewList;
    }

    public ArrayList<Image> readImageCP(int option) {
        if (option == 1) {
            caracterP = new File(dataFolder + "/desencriptados/caracterPrincipal/corriendoD");
        } else if (option == 2) {
            caracterP = new File(dataFolder + "/desencriptados/caracterPrincipal/corriendoI");
        }else if (option == 3) {
            caracterP = new File(dataFolder + "/desencriptados/iconos");
        }
            File folder = caracterP;
            File[] pngFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));
            ArrayList<Image> imageList = new ArrayList<>();

            if (pngFiles != null) {
                for (File pngFile : pngFiles) {
                    Image image = new Image(pngFile.toURI().toString());
                    imageList.add(image);
                }
            }

            return imageList;
        }

    public ArrayList<Image> readImagenemy () {
        enemy = new File(dataFolder + "/desencriptados/enemigos/corriendoD");
        File folder = enemy;
        File[] pngFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));
        ArrayList<Image> imageList = new ArrayList<>();

        if (pngFiles != null) {
            for (File pngFile : pngFiles) {
                Image image = new Image(pngFile.toURI().toString());
                imageList.add(image);
            }
        }

        return imageList;
    }

    public Image imageFirstWindow(){
        iconos=new File(dataFolder + "/iconos");
        File folder=iconos;
        File[] pngFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg"));
        ArrayList<Image> imageList = new ArrayList<>();

        if (pngFiles != null) {
            for (File pngFile : pngFiles) {
                Image image = new Image(pngFile.toURI().toString());
                imageList.add(image);
            }
        }
        return imageList.get(0);
    }

    public Image imageNenufar(int option){
        iconos=new File(dataFolder + "/Nenufar");
        File folder=iconos;
        File[] pngFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));
        ArrayList<Image> imageList = new ArrayList<>();

        if (pngFiles != null) {
            for (File pngFile : pngFiles) {
                Image image = new Image(pngFile.toURI().toString());
                imageList.add(image);
            }
        }
        return imageList.get(option);
    }

}