package com.example.demo.ClasesGrafos;

public class Edge<V, T> {
    V destino;
    T peso;

    public Edge(V destino, T peso) {
        this.destino = destino;
        this.peso = peso;
    }
}
