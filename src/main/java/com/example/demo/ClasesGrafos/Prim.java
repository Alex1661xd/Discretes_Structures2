package com.example.demo.ClasesGrafos;

import java.util.*;

public class Prim {

    public static Set<Edge> prim(Graph graph) {
        Set<Integer> visited = new HashSet<>();
        Set<Edge> minimumSpanningTree = new HashSet<>();
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

        int startVertex = graph.getVertices().iterator().next();
        visited.add(startVertex);

        minHeap.addAll(graph.getEdges(startVertex));

        while (!minHeap.isEmpty() && visited.size() < graph.getVertices().size()) {
            Edge edge = minHeap.poll();

            int destination = edge.getDestination();
            if (!visited.contains(destination)) {
                visited.add(destination);
                minimumSpanningTree.add(edge);
                minHeap.addAll(graph.getEdges(destination));
            }
        }

        return minimumSpanningTree;
    }
}
