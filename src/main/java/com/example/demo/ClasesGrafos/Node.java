package com.example.demo.ClasesGrafos;

public class Node {
    private int vertex;
    private int distance;

    public Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    public int getVertex() {
        return vertex;
    }

    public int getDistance() {
        return distance;
    }
}
