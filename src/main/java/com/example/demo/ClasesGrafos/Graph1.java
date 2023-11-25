package com.example.demo.ClasesGrafos;

import javafx.util.Pair;

import java.util.*;

public class Graph1<V, T> {
    private Map<V, List<Edge<V, T>>> adj;

    public Graph1() {
        adj = new HashMap<>();
    }

    /**
     * Adds a vertex to the graph.
     *
     * @param vertice The vertex to be added.
     */
    public void agregarVertice(V vertice) {
        adj.put(vertice, new LinkedList<>());
    }
    /**
     * Adds an edge between two vertices with a specified weight.
     *
     * @param v    The source vertex.
     * @param w    The destination vertex.
     * @param peso The weight of the edge.
     */
    public void agregarArista(V v, V w, T peso) {
        adj.computeIfAbsent(v, k -> new LinkedList<>()).add(new Edge<>(w, peso));
    }

    /**
     * Prints the graph, displaying the vertices and edges along with their weights.
     */
    public void imprimirGrafo() {
        for (V origen : adj.keySet()) {
            for (Edge<V, T> arista : adj.get(origen)) {
                V destino = arista.destino;
                T peso = arista.peso;
                System.out.println(origen + " -> " + destino + " : " + peso);
            }
        }
    }
    /**
     * Connects vertices randomly in the graph with specified constraints.
     *
     * @param numVertices The number of vertices in the graph.
     * @param maxAristas  The maximum number of edges for each vertex.
     * @param maxPeso     The maximum weight for the edges.
     */
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
    /**
     * Performs Breadth-First Search (BFS) to obtain neighbors of a vertex.
     *
     * @param inicio The starting vertex for BFS.
     * @return A list of vertices representing the neighbors in BFS order.
     */
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
    /**
     * Applies Dijkstra's algorithm to find the shortest path from the start vertex to the destination vertex.
     *
     * @param inicio   The starting vertex.
     * @param destino  The destination vertex.
     * @return The minimum distance between the start and destination vertices.
     */
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
