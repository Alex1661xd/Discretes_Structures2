package com.example.demo.ClasesGrafos;

public class Edge<T> {
    private T destino;
    private int peso;

    public Edge(T destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public T getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }
}
