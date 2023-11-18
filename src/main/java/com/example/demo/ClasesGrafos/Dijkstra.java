package com.example.demo.ClasesGrafos;

import java.util.*;

public class Dijkstra {

    public static Map<Integer, Integer> dijkstra(Graph1 graph, int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (int vertex : graph.getVertices()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }

        distances.put(start, 0);
        minHeap.add(new Node(start, 0));

        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll();

            for (Edge edge : graph.getEdges(current.vertex)) {
                int newDistance = distances.get(current.vertex) + edge.getWeight();

                if (newDistance < distances.get(edge.getDestination())) {
                    distances.put(edge.getDestination(), newDistance);
                    minHeap.add(new Node(edge.getDestination(), newDistance));
                }
            }
        }

        return distances;
    }

    static class Node {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}

