package com.example.demo.controllers;

import com.example.demo.ClasesGrafos.Graph1;
import com.example.demo.ClasesGrafos.Graph2;

import java.util.*;

public class GraphsController {
    private Graph1<String, Integer> grafo1;
    private int typeGraph;
    private static GraphsController graphCont;
    private Random random;

    private Graph2<String, Integer> grafo2;

    private GraphsController() {
        grafo1 = new Graph1<>();
        random = new Random();
        grafo2=new Graph2<>();
    }

    public static GraphsController getInstance() {
        if (graphCont == null) graphCont = new GraphsController();
        return graphCont;
    }

    public int getTypeGraph() {
        return typeGraph;
    }

    public void setTypeGraph(int typeGraph) {
        this.typeGraph = typeGraph;
    }

    public void addGraph() {
        int typeGraph = getTypeGraph();
        if (typeGraph == 1) {
            addGraph1();
        } else if (typeGraph == 2) {
            addGraph2();
        }
    }

    private void addGraph1() {
        grafo1.conectarAleatoriamente(51,3,4);
        //grafo1.imprimirGrafo();
    }
    private void addGraph2() {
       grafo2.conectarAleatoriamente(51,3,4);
       grafo2.imprimirGrafo();System.out.println("Grafo2");
    }


    public int showDistanciasCortas(String VInicio, String VFinal) {
        int msg = -1;
        if(typeGraph==1){
            msg=grafo1.dijkstra(VInicio, VFinal);
        }else if(typeGraph==2){
            //msg= Integer.parseInt(grafo2.dijkstra(VInicio,VFinal));
            msg=grafo2.dijkstra(VInicio,VFinal);
        }
        return msg;
    }

    public String showConnections(String vertice) {
        StringBuilder msg = new StringBuilder();
        List<String> conexiones=null;

        if(typeGraph==2){
            conexiones=grafo2.dfsConVecinos(vertice);
        }else if(typeGraph==1){
            conexiones = getConnectionsBFS(vertice);
        }
        conexiones.remove(vertice);

        // Excluir el vértice de origen de la lista de conexiones
        if (conexiones.isEmpty()) {
            msg.append("No connection.");
        } else {
            msg.append(String.join(", ", conexiones));
        }
        return msg.toString();
    }

    private List<String> getConnectionsBFS(String vertice) {
        List<String> conexiones = new ArrayList<>();
        List<String> vecinos = grafo1.obtenerVecinosBFS(vertice);
        conexiones.addAll(vecinos);
        return conexiones;
    }



}

