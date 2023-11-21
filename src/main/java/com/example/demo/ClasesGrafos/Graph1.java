package com.example.demo.ClasesGrafos;

import java.util.*;
import javafx.util.Pair;
public class Graph1<V, T> {
    private Map<V, List<Edge<V, T>>> adj;

    public Graph1() {
        adj = new HashMap<>();
    }

    public void agregarArista(V v, V w, T peso) {
        adj.computeIfAbsent(v, k -> new LinkedList<>()).add(new Edge<>(w, peso));
        // Si las aristas son bidireccionales, también agrega una arista en el sentido opuesto:
        // adj.computeIfAbsent(w, k -> new LinkedList<>()).add(new Arista<>(v, peso));
    }

    public List<V> obtenerVecinos(V vertice) {
        List<V> vecinos = new ArrayList<>();

        List<Edge<V, T>> aristas = adj.getOrDefault(vertice, new LinkedList<>());
        for (Edge<V, T> arista : aristas) {
            vecinos.add(arista.destino);
        }

        return vecinos;
    }

    public int dijkstra(V inicio, V destino) {
        Map<V, Integer> distancias = new HashMap<>();
        PriorityQueue<Pair<Integer, V>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));

        distancias.put(inicio, 0);
        priorityQueue.add(new Pair<>(0, inicio));

        while (!priorityQueue.isEmpty()) {
            V actual = priorityQueue.poll().getValue();

            if (actual.equals(destino)) {
                // Hemos llegado al destino, puedes manejarlo según tus necesidades
                break;
            }

            List<Edge<V, T>> aristas = adj.getOrDefault(actual, new LinkedList<>());
            for (Edge<V, T> arista : aristas) {
                V siguiente = arista.destino;
                int nuevaDistancia = distancias.get(actual) + (int) arista.peso;

                if (!distancias.containsKey(siguiente) || nuevaDistancia < distancias.get(siguiente)) {
                    distancias.put(siguiente, nuevaDistancia);
                    priorityQueue.add(new Pair<>(nuevaDistancia, siguiente));
                }
            }
        }

        int msg=-1;

        if (distancias.containsKey(inicio) && distancias.containsKey(destino)) {
            msg=distancias.get(destino);
        }

        return msg;
    }
}
