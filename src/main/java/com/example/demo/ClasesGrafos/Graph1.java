package com.example.demo.ClasesGrafos;

import java.util.*;

public class Graph1<T> {

    //Grafo con Lista de adyacencia y Dijkstra
    public Map<Vertex<T>, List<Edge<T>>> listaAdyacencia = new HashMap<>();
    public void agregarAristaLista(Vertex<T> origen, Vertex<T> destino, int peso) {
        listaAdyacencia.computeIfAbsent(origen, k -> new ArrayList<>()).add((Edge<T>) new Edge<>(destino.getName(), peso));
        listaAdyacencia.computeIfAbsent(destino, k -> new ArrayList<>()).add((Edge<T>) new Edge<>(origen.getName(), peso));
    }
    public Map<Vertex<T>, Integer> dijkstra(Vertex<T> inicio) {
        Map<Vertex<T>, Integer> distancias = new HashMap<>();
        PriorityQueue<Vertex<T>> cola = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

        distancias.put(inicio, 0);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            Vertex<T> actual = cola.poll();

            for (Edge<T> arista : listaAdyacencia.getOrDefault(actual, Collections.emptyList())) {
                int nuevaDistancia = distancias.get(actual) + arista.getPeso();
                if (!distancias.containsKey(arista.getDestino()) || nuevaDistancia < distancias.get(arista.getDestino())) {
                    distancias.put((Vertex<T>) arista.getDestino(), nuevaDistancia);
                    cola.add((Vertex<T>) arista.getDestino());
                }
            }
        }

        return distancias;
    }

    public List<Vertex<T>> bfsLista(Vertex<T> inicio) {
        List<Vertex<T>> resultado = new ArrayList<>();
        Queue<Vertex<T>> cola = new LinkedList<>();
        Set<Vertex<T>> visitados = new HashSet<>();

        cola.add(inicio);
        visitados.add(inicio);

        while (!cola.isEmpty()) {
            Vertex<T> actual = cola.poll();
            resultado.add(actual);

            for (Edge<T> arista : listaAdyacencia.getOrDefault(actual, Collections.emptyList())) {
                Vertex<T> vecino = (Vertex<T>) arista.getDestino();
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }

        return resultado;
    }

    public void mostrarConexiones(String nombreVertice) {
        Vertex<T> verticeBuscado = null;
        String msg="";
        // Buscar el vértice por su nombre
        for (Vertex<T> vertice : listaAdyacencia.keySet()) {
            if (vertice.getName().equals(nombreVertice)) {
                verticeBuscado = vertice;
                break;
            }
        }

        // Mostrar las conexiones del vértice encontrado
        if (verticeBuscado != null) {
            List<Edge<T>> conexiones = listaAdyacencia.get(verticeBuscado);

            msg="Conexiones de " + nombreVertice + ":";
            for (Edge<T> conexion : conexiones) {
                msg+="  Destino: " + ((Vertex<T>)conexion.getDestino()).getName() + ", Peso: " + conexion.getPeso();
            }
        } else {
            msg+="Vertice no encontrado: " + nombreVertice;
        }
    }


}
