package com.example.demo.ClasesGrafos;

public class Node<V> {
    V vertice;
    int distancia;

    Node(V vertice, int distancia) {
        this.vertice = vertice;
        this.distancia = distancia;
    }
}