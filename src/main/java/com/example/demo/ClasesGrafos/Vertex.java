package com.example.demo.ClasesGrafos;

public class Vertex<T> {
    private T data;
    private String name;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


