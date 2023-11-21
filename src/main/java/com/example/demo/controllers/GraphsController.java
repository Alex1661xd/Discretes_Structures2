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
        Random random = new Random();

        for (int i = 0; i <= 50; i++) {
            int pesoArista1 = random.nextInt(5) + 1;
            int pesoArista2 = random.nextInt(5) + 1;

            // Conectar el vértice actual a dos vértices aleatorios con pesos aleatorios
            String verticeDestino1 = "V" + (random.nextInt(51));
            String verticeDestino2 = "V" + (random.nextInt(51));

            grafo1.agregarArista("V" + i, verticeDestino1, pesoArista1);
            grafo1.agregarArista("V" + i, verticeDestino2, pesoArista2);
        }

    }

    public int showDistanciasCortas(String VInicio, String VFinal) {
        int msg = -1;
        msg=grafo1.dijkstra(VInicio, VFinal);
        return msg;
    }

    public String showConnections(String vertice) {
        StringBuilder msg = new StringBuilder();
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
