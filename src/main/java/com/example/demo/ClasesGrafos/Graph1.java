package com.example.demo.ClasesGrafos;

import javafx.util.Pair;

import java.util.*;

public class Graph1<V, T> {
    private Map<V, List<Edge<V, T>>> adj;

    public Graph1() {
        adj = new HashMap<>();
    }

    public void agregarVertice(V vertice) {
        adj.put(vertice, new LinkedList<>());
    }

    public void agregarArista(V v, V w, T peso) {
        adj.computeIfAbsent(v, k -> new LinkedList<>()).add(new Edge<>(w, peso));
    }

    public void imprimirGrafo() {
        for (V origen : adj.keySet()) {
            for (Edge<V, T> arista : adj.get(origen)) {
                V destino = arista.destino;
                T peso = arista.peso;
                System.out.println(origen + " -> " + destino + " : " + peso);
            }
        }
    }

    public void conectarAleatoriamente(int numVertices, int maxAristas, int maxPeso) {
        Random random = new Random();

        for (int i = 0; i < numVertices; i++) {
            V vertice = (V) ("V" + i);
            agregarVertice(vertice);

            int numAristas = random.nextInt(maxAristas) + 1;

            for (int j = 0; j < numAristas; j++) {
                V verticeDestino = null;
                final V finalVerticeDestino = verticeDestino;
                do {
                    verticeDestino = (V) ("V" + (random.nextInt(numVertices)));
                } while (adj.get(vertice).stream().anyMatch(edge -> edge.destino.equals(finalVerticeDestino)));

                T pesoArista = (T) Integer.valueOf(random.nextInt(maxPeso) + 1);

                agregarArista(vertice, verticeDestino, pesoArista);
            }
        }
    }

    public List<V> obtenerVecinosBFS(V inicio) {
        List<V> vecinos = new ArrayList<>();
        Set<V> visitados = new HashSet<>();
        Queue<V> cola = new LinkedList<>();

        cola.add(inicio);
        visitados.add(inicio);

        while (!cola.isEmpty()) {
            V actual = cola.poll();
            vecinos.add(actual);

            List<Edge<V, T>> aristas = adj.getOrDefault(actual, new LinkedList<>());
            for (Edge<V, T> arista : aristas) {
                V vecino = arista.destino;
                if (!visitados.contains(vecino)) {
                    cola.add(vecino);
                    visitados.add(vecino);
                }
            }
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

        int msg = -1;

        if (distancias.containsKey(inicio) && distancias.containsKey(destino)) {
            msg = distancias.get(destino);
        }

        return msg;
    }

}
