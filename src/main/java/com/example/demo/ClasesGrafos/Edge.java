package com.example.demo.ClasesGrafos;

public class Edge<V, T> {
    V destino;
    T peso;

    public Edge(V destino, T peso) {
        this.destino = destino;
        this.peso = peso;
    }

    // Dentro de la clase Edge
    @Override
    public String toString() {
        return destino.toString(); // Suponiendo que "destino" es un objeto que puede convertirse a cadena
    }

}
