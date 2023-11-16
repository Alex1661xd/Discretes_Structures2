package com.example.demo.Classes;

import com.example.demo.controllers.GameController1;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Background {
    GameController1 gp;
    ArrayList<BackgroundEn> tile;
    public double[][] mapBackNum;
    DataReader lector;

    public Background(GameController1 gp) {
        this.gp = gp;
        tile= new ArrayList<>();
        lector=new DataReader();
        mapBackNum= new double[16][12];
        getResources();
        loadMap();
    }

    public void getResources(){
        ArrayList<Image>iconosSen= lector.readImageBackground(5);
        for (int i = 0; i < iconosSen.size(); i++) {
            tile.add(new BackgroundEn());
            tile.get(i).background=iconosSen.get(i);
            if(i>2){
                tile.get(i).collision=true;
            }
        }
    }

    public void loadMap() {
        try {
            File projectDir = new File(System.getProperty("user.dir"));
            File dataFolder = new File(projectDir + "/recursos/maps");

            // Suponiendo que tu archivo se llama "map1.txt"
            File mapFile = new File(dataFolder, "map1.txt");

            // Utiliza FileInputStream para cargar el archivo
            InputStream is = new FileInputStream(mapFile);

            if (is != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                int col = 0;
                int row = 0;
                while (col < 16 && row < 12) {
                    String line = br.readLine();

                    while (col < 16) {
                        String[] numbers = line.split(" ");
                        double num = Double.parseDouble(numbers[col]);
                        mapBackNum[col][row] = num;
                        col++;
                    }
                    if (col == 16) {
                        col = 0;
                        row++;
                    }
                }
                br.close();
            } else {
                System.err.println("No se pudo cargar el archivo: " + mapFile.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paint(GraphicsContext g) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < 16 && row < 12) {
            double num = mapBackNum[col][row];
            g.drawImage(tile.get((int) num).background, x, y, 48, 48);
            col++;
            x += 48;
            if (col == 16) {
                col = 0;
                x = 0;
                row++;
                y += 48;
            }
        }
    }

}
