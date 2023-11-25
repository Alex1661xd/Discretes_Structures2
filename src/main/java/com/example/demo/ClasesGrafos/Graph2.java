package com.example.demo.ClasesGrafos;

import javafx.util.Pair;
import java.util.*;

public class Graph2<V, T> {
    private Map<V, Integer> vertexIndexMap;
    private List<V> vertices;
    private Edge<V, T>[][] adjacencyMatrix; // Cambio de int[][] a Edge<V, T>[][]

    public Graph2() {
        vertexIndexMap = new HashMap<>();
        vertices = new ArrayList<>();
        adjacencyMatrix = new Edge[0][0]; // Cambio de int[0][0] a Edge[0][0]
    }
    /**
     * Adds a vertex to the graph if it does not already exist.
     *
     * @param vertice The vertex to be added.
     */
    public void agregarVertice(V vertice) {
        if (!vertexIndexMap.containsKey(vertice)) {
            int newIndex = vertices.size();
            vertexIndexMap.put(vertice, newIndex);
            vertices.add(vertice);
            actualizarMatriz();
        }
    }
    /**
     * Adds an edge between two vertices with a specified weight.
     *
     * @param v    The source vertex.
     * @param w    The destination vertex.
     * @param peso The weight of the edge.
     */
    public void agregarArista(V v, V w, T peso) {
        if (vertexIndexMap.containsKey(v) && vertexIndexMap.containsKey(w)) {
            int indexV = vertexIndexMap.get(v);
            int indexW = vertexIndexMap.get(w);
            // Cambio de asignación a 1 a asignación de Edge
            adjacencyMatrix[indexV][indexW] = new Edge<>(w, peso);
        } else {
            // Manejar el caso en que uno o ambos vértices no están en el mapa
            System.out.println("Al menos uno de los vértices no está en el mapa.");
        }
    }

    /**
     * Prints the graph, displaying the vertices and edges along with their weights.
     */
    public void imprimirGrafo() {
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                Edge<V, T> edge = adjacencyMatrix[i][j];
                if (edge != null) {
                    V origen = vertices.get(i);
                    V destino = edge.destino;
                    T peso = edge.peso;
                    System.out.println(origen + " -> " + destino + " : " + peso);
                }
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
            agregarVertice(vertice); // Asegúrate de agregar el vértice al mapa

            int numAristas = random.nextInt(maxAristas) + 1;

            for (int j = 0; j < numAristas; j++) {
                V verticeDestino = null;
                do {
                    verticeDestino = (V) ("V" + (random.nextInt(numVertices)));
                    agregarVertice(verticeDestino); // Asegúrate de agregar el vérticeDestino al mapa
                } while (adyacenciaExistente(vertice, verticeDestino));

                T pesoArista = (T) Integer.valueOf(random.nextInt(maxPeso) + 1);
                agregarArista(vertice, verticeDestino, pesoArista);
            }
        }
    }
    /**
     * Checks if an adjacency exists between two vertices.
     *
     * @param v The source vertex.
     * @param w The destination vertex.
     * @return True if an adjacency exists, false otherwise.
     */
    private boolean adyacenciaExistente(V v, V w) {
        Integer indexV = vertexIndexMap.get(v);
        Integer indexW = vertexIndexMap.get(w);

        // Verificar si los índices son no nulos antes de acceder a la matriz
        return indexV != null && indexW != null && adjacencyMatrix[indexV][indexW] != null;
    }

    /**
     * Performs Depth-First Search (DFS) and returns a list of vertices in DFS order.
     *
     * @param inicio The starting vertex for DFS.
     * @return A list of vertices in DFS order.
     */
    public List<String> dfsConVecinos(V inicio) {
        boolean[] visitados = new boolean[vertices.size()];
        List<String> result = new ArrayList<>();
        dfsRecursivoConVecinos(vertexIndexMap.get(inicio), visitados, result);
        return result;
    }
    /**
     * Recursive helper method for DFS traversal.
     *
     * @param start   The index of the starting vertex.
     * @param visited Array to track visited vertices.
     * @param result  The result list to store vertices in DFS order.
     */
    private void dfsRecursivoConVecinos(int start, boolean[] visited, List<String> result) {
        result.add(vertices.get(start).toString());
        visited[start] = true;

        for (int i = 0; i < vertices.size(); i++) {
            Edge<V, T> edge = adjacencyMatrix[start][i];
            if (edge != null && !visited[i]) {
                result.add(vertices.get(i).toString()); // Agregar el vecino a la lista
                dfsRecursivoConVecinos(i, visited, result);
            }
        }
    }

    /**
     * Applies Dijkstra's algorithm to find the shortest path from the start vertex to the destination vertex.
     *
     * @param inicio   The starting vertex.
     * @param destino  The destination vertex.
     * @return The minimum distance between the start and destination vertices.
     */
    public int dijkstra(V inicio, V destino) {
        int start = vertexIndexMap.get(inicio);
        int end = vertexIndexMap.get(destino);

        Map<Integer, Integer> distancias = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));

        distancias.put(start, 0);
        priorityQueue.add(new Pair<>(0, start));

        while (!priorityQueue.isEmpty()) {
            int actual = priorityQueue.poll().getValue();

            if (actual == end) {
                break;
            }

            for (int i = 0; i < vertices.size(); i++) {
                Edge<V, T> edge = adjacencyMatrix[actual][i];
                if (edge != null) {
                    int nuevaDistancia = distancias.getOrDefault(actual, Integer.MAX_VALUE) + 1;

                    if (nuevaDistancia < distancias.getOrDefault(i, Integer.MAX_VALUE)) {
                        distancias.put(i, nuevaDistancia);
                        priorityQueue.add(new Pair<>(nuevaDistancia, i));
                    }
                }
            }
        }

        return distancias.getOrDefault(end, -1);
    }
    /**
     * Updates the adjacency matrix to match the current vertices in the graph.
     */
    private void actualizarMatriz() {
        int newSize = vertices.size();
        Edge<V, T>[][] nuevaMatriz = new Edge[newSize][newSize];

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.arraycopy(adjacencyMatrix[i], 0, nuevaMatriz[i], 0, adjacencyMatrix[i].length);
        }

        adjacencyMatrix = nuevaMatriz;
    }

}
