package com.example.demo.controllers;

import com.example.demo.ClasesGrafos.Graph1;

import java.util.*;

public class GraphsController {
    private Graph1<String, Integer> grafo1;
    private int typeGraph;
    private static GraphsController graphCont;
    private Random random;

    private GraphsController() {
        grafo1 = new Graph1<>();
        random = new Random();
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
            //addVertexGraph2();
        }
    }

    private void addGraph1() {
        grafo1.agregarArista("V1", "V2", 0);
        grafo1.agregarArista("V1", "V3", 2);
        grafo1.agregarArista("V2", "V4", 5);
        grafo1.agregarArista("V3", "V4", 1);
        grafo1.agregarArista("V4", "V5", 3);
        grafo1.agregarArista("V3", "V6", 3);
        grafo1.agregarArista("V4", "V7", 1);
    }

    public String showDistanciasCortas(String VInicio, String VFinal) {
        String msg = "Distancias más cortas desde " + VInicio + ":";
        msg+=grafo1.dijkstra(VInicio, VFinal);
        return msg;
    }

    public String showConnections(String vertice) {
        StringBuilder msg = new StringBuilder("Conexiones de " + vertice + ": ");
        List<String> conexiones = getConnections(vertice);

        if (conexiones.isEmpty()) {
            msg.append("Ninguna conexión.");
        } else {
            msg.append(String.join(", ", conexiones));
        }

        return msg.toString();
    }

    private List<String> getConnections(String vertice) {
        List<String> conexiones = new ArrayList<>();
        if (typeGraph == 1) {
            List<String> vecinos = grafo1.obtenerVecinos(vertice);
            conexiones.addAll(vecinos);
        }
        // Agrega lógica para el grafo2 si es necesario

        return conexiones;
    }
}
