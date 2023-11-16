package com.example.demo.ClasesGrafos;

import java.util.*;

public class Graph {
    private Map<Integer, List<Edge>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencyList.get(source).add(edge);
        adjacencyList.get(destination).add(edge); // Para un grafo no dirigido, se puede comentar esta línea
    }

    public Set<Integer> getVertices() {
        return adjacencyList.keySet();
    }

    public List<Edge> getEdges(int vertex) {
        return adjacencyList.get(vertex);
    }
}
