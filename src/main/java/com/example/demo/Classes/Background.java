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

    private static Background background;
    GameController1 gp;
    ArrayList<BackgroundEn> tile;
    public double[][] mapBackNum;
    ArrayList<String> combinaciones;

    ArrayList<Nenufar> nenufares;
    DataReader lector;

    int contador=0;

    KeyHandler keyH;
    /**
     * Private constructor for the Background class.
     *
     * @param gp   The GameController1 instance.
     * @param keyH The KeyHandler instance.
     */
    private Background(GameController1 gp, KeyHandler keyH) {
        nenufares=new ArrayList<>();
        this.keyH=keyH;
        this.gp = gp;
        tile= new ArrayList<>();
        lector=new DataReader();
        combinaciones = new ArrayList<>();
        mapBackNum= new double[16][12];
        getResources();
        loadMap();
    }
    /**
     * Gets an instance of Background using the Singleton pattern.
     *
     * @param gp   The GameController1 instance.
     * @param keyH The KeyHandler instance.
     * @return The Background instance.
     */
    public static Background BackgroundGetInstance(GameController1 gp,KeyHandler keyH){
        if(background==null){
            background=new Background(gp,keyH);
        }else{
            return background;
        }
        return background;
    }

    /**
     * Loads resources, including images for the background tiles.
     */
    public void getResources(){
        ArrayList<Image>iconosSen= lector.readImageBackground(5);
        for (int i = 0; i < iconosSen.size(); i++) {
            tile.add(new BackgroundEn());
            tile.get(i).setBackground(iconosSen.get(i));
            if(i==3||i==5||i==9||i==7){
                tile.get(i).setCollision(true);
            }
        }
    }
    /**
     * Loads the map from a file and initializes the mapBackNum array.
     */
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
    /**
     * Paints the background using the loaded map and tiles.
     *
     * @param g The GraphicsContext for painting.
     */
    public void paint(GraphicsContext g) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < 16 && row < 12) {
            double num = mapBackNum[col][row];
            if (num==0||num==10){
                nenufares.add(new Nenufar(x,y,"V"+contador));
                if(contador==6||contador==8||contador==19||contador==21||contador==31||contador==43||contador==48||contador==59||contador==63){
                    nenufares.get(contador).enemy=true;
                }
                contador++;
            }
            g.drawImage(tile.get((int) num).getBackground(), x, y, 48, 48);
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

    /**
     * Gets the list of combinations.
     *
     * @return The list of combinations.
     */
    public ArrayList<String> getCombinaciones() {
        return combinaciones;
    }
    /**
     * Searches for a Nenufar with the given name.
     *
     * @param name The name of the Nenufar to search for.
     * @return The Nenufar with the given name, or null if not found.
     */
    public Nenufar searchTile(String name){
        for (int i = 0; i < nenufares.size(); i++) {
            if(nenufares.get(i).name.equals(name)){
                return nenufares.get(i);

            }
        }
        return null;
    }
    /**
     * Searches for a Nenufar with the corona property.
     *
     * @return The name of the Nenufar with the corona property, or null if not found.
     */
    public String searchTileCorona(){
        for (int i = 0; i < nenufares.size(); i++) {
            if(nenufares.get(i).corona){
                return nenufares.get(i).name;

            }
        }
        return null;
    }
    /**
     * Gets the list of background tiles.
     *
     * @return The list of background tiles.
     */

    public ArrayList<BackgroundEn> getTile() {
        return tile;
    }
}