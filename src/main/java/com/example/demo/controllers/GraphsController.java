package com.example.demo.controllers;

import com.example.demo.ClasesGrafos.Edge;
import com.example.demo.ClasesGrafos.Graph1;
import com.example.demo.ClasesGrafos.Graph2;
import com.example.demo.ClasesGrafos.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GraphsController {
    private Graph1 grafo1;
    private Graph2 grafo2;
    static private GraphsController graphCont;
    private int typeGraph;

    private Random random;

    ArrayList<String> combinaciones;

    private GraphsController() {
        grafo1=new Graph1();
        grafo2=new Graph2();
        combinaciones = new ArrayList<>();
        combinacionesList();
        random=new Random();
    }

    static public GraphsController getInstance(){
        if(graphCont==null) graphCont = new GraphsController();
        return graphCont;
    }

    public int getTypeGraph() {
        return typeGraph;
    }

    public void setTypeGraph(int typeGraph) {
        this.typeGraph = typeGraph;
    }

    public void addVertex(){
        int typeGraph=getTypeGraph();
        if(typeGraph==1){
            addVertexGraph1();
        }else if(typeGraph==2){
            addVertexGraph2();
        }

    }

    void addVertexGraph1(){
        List<String> copiaCombinaciones = new ArrayList<>(combinaciones);

        while (!copiaCombinaciones.isEmpty()){
            int numOrigen = random.nextInt(copiaCombinaciones.size());
            int numDestino = random.nextInt(copiaCombinaciones.size());

            while (numOrigen == numDestino){
                numDestino = random.nextInt(copiaCombinaciones.size());
            }

            String nameOrigen = copiaCombinaciones.get(numOrigen);
            String nameDestino = copiaCombinaciones.get(numDestino);

            Vertex vertexI = new Vertex<>(nameOrigen);
            Vertex vertexD = new Vertex<>(nameDestino);
            int peso = random.nextInt(6);

            grafo1.agregarAristaLista(vertexI, vertexD, peso);

            // Remover elementos de la lista original
            combinaciones.remove(nameOrigen);
            combinaciones.remove(nameDestino);

            // Actualizar la copia de la lista
            copiaCombinaciones = new ArrayList<>(combinaciones);
        }
    }

    void addVertexGraph2(){
        while (!combinaciones.isEmpty()){
            int numOrigen=random.nextInt(combinaciones.size());
            int numDestino=random.nextInt(combinaciones.size());
            while (numOrigen==numDestino){
                numDestino=random.nextInt(combinaciones.size());
            }
            String nameOrigen= combinaciones.get(numOrigen);
            String nameDestino=combinaciones.get(numDestino);
            Vertex<String> vertexI= new Vertex<>(nameOrigen);
            Vertex<String> vertexD= new Vertex<>(nameDestino);
            int peso=random.nextInt(6);
            grafo2.agregarAristaMatriz(vertexI,vertexD,peso);
            combinaciones.remove(numOrigen);
            combinaciones.remove(numDestino);
        }
    }

    public String showConextions(){
        int typeGraph=getTypeGraph();
        if(typeGraph==1){
            showConnectionsGraph1BFS("hj");
        }else if(typeGraph==2){
            addVertexGraph2();
        }
        return "h";
    }

    public void showConnectionsGraph1BFS(String nameVertex) {
        // Buscar el vértice con BFS
        Vertex<String> vertexToFind = null;
        for (Object objVertice : grafo1.listaAdyacencia.keySet()) {
            Vertex<String> vertice = (Vertex<String>) objVertice;
            if (vertice.getName().equals(nameVertex)) {
                vertexToFind = vertice;
                break;
            }
        }

        if (vertexToFind == null) {
            System.out.println("Vértice con nombre " + nameVertex + " no encontrado en el grafo.");
            return;
        }

        // Realizar BFS desde el vértice encontrado
        List<Vertex<String>> bfsResult = grafo1.bfsLista(vertexToFind);

        // Mostrar conexiones
        System.out.print("Conexiones de " + vertexToFind.getName() + ": ");
        for (Vertex<String> resultado : bfsResult) {
            List<Edge<String>> aristas = (List<Edge<String>>) grafo1.listaAdyacencia.getOrDefault(resultado, Collections.emptyList());
            for (Edge<String> arista : aristas) {
                System.out.print("(" + ((Vertex)arista.getDestino().getName())+ ", Peso: " + arista.getPeso() + ") ");
            }
        }

        System.out.println();
    }

    public void combinacionesList(){
        for (int i = 1; i <= 50; i++) {
            String combinacion = obtenerCombinacion(i);
            combinaciones.add(combinacion);
        }
    }
    private static String obtenerCombinacion(int numero) {
        char primeraLetra = (char) ('A' + (numero - 1) % 26);
        char ultimaLetra = (char) ('Z' - (numero - 1) % 26);
        return String.valueOf(primeraLetra) + String.valueOf(ultimaLetra);
    }
    public ArrayList<String> getCombinaciones() {
        return combinaciones;
    }

}
