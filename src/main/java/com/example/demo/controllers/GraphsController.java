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
    /**
     * Gets an instance of GraphsController using the Singleton pattern.
     *
     * @return The GraphsController instance.
     */
    public static GraphsController getInstance() {
        if (graphCont == null) graphCont = new GraphsController();
        return graphCont;
    }
    /**
     * Gets the type of the graph.
     *
     * @return The type of the graph.
     */
    public int getTypeGraph() {
        return typeGraph;
    }

    /**
     * Sets the type of the graph.
     *
     * @param typeGraph The type of the graph.
     */
    public void setTypeGraph(int typeGraph) {
        this.typeGraph = typeGraph;
    }
    /**
     * Adds a graph based on the selected type.
     */
    public void addGraph() {
        int typeGraph = getTypeGraph();
        if (typeGraph == 1) {
            addGraph1();
        } else if (typeGraph == 2) {
            addGraph2();
        }
    }
    /**
     * Adds a graph of type 1.
     */
    private void addGraph1() {
        grafo1.conectarAleatoriamente(51,3,4);
        //grafo1.imprimirGrafo();
    }
    /**
     * Adds a graph of type 2.
     */
    private void addGraph2() {
       grafo2.conectarAleatoriamente(51,3,4);
       grafo2.imprimirGrafo();System.out.println("Grafo2");
    }

    /**
     * Shows the shortest distances between two vertices.
     *
     * @param VInicio The starting vertex.
     * @param VFinal  The ending vertex.
     * @return The shortest distance.
     */
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
    /**
     * Shows the connections of a vertex.
     *
     * @param vertice The vertex to show connections for.
     * @return A string representing the connections.
     */
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
    /**
     * Gets the connections using BFS for graph type 1.
     *
     * @param vertice The vertex to find connections for.
     * @return A list of connections.
     */
    private List<String> getConnectionsBFS(String vertice) {
        List<String> conexiones = new ArrayList<>();
        List<String> vecinos = grafo1.obtenerVecinosBFS(vertice);
        conexiones.addAll(vecinos);
        return conexiones;
    }



}

