package com.example.demo.ClasesGrafos;

import java.util.*;

public class Graph2<T> {

    //Grafo con DFS (Matriz de adyacencia), Floyd
    private Map<Vertex<T>, Map<Vertex<T>, Integer>> matrizAdyacencia = new HashMap<>();

    public void agregarAristaMatriz(Vertex<T> origen, Vertex<T> destino, int peso) {
        matrizAdyacencia.computeIfAbsent(origen, k -> new HashMap<>()).put(destino, peso);
        matrizAdyacencia.computeIfAbsent(destino, k -> new HashMap<>()).put(origen, peso);
    }

    public Map<Vertex<T>, Map<Vertex<T>, Integer>> floydWarshall() {
        Map<Vertex<T>, Map<Vertex<T>, Integer>> distancias = new HashMap<>(matrizAdyacencia);

        for (Vertex<T> k : matrizAdyacencia.keySet()) {
            for (Vertex<T> i : matrizAdyacencia.keySet()) {
                for (Vertex<T> j : matrizAdyacencia.keySet()) {
                    if (!distancias.get(i).containsKey(j)) {
                        distancias.get(i).put(j, Integer.MAX_VALUE);
                    }
                    int distanciaIK = distancias.get(i).get(k);
                    int distanciaKJ = distancias.get(k).get(j);

                    if (distanciaIK != Integer.MAX_VALUE && distanciaKJ != Integer.MAX_VALUE &&
                            distanciaIK + distanciaKJ < distancias.get(i).get(j)) {
                        distancias.get(i).put(j, distanciaIK + distanciaKJ);
                    }
                }
            }
        }

        return distancias;
    }

    public List<Vertex<T>> dfsMatriz(Vertex<T> inicio) {
        List<Vertex<T>> resultado = new ArrayList<>();
        Set<Vertex<T>> visitados = new HashSet<>();

        dfsRecursivoMatriz(inicio, visitados, resultado);

        return resultado;
    }

    private void dfsRecursivoMatriz(Vertex<T> actual, Set<Vertex<T>> visitados, List<Vertex<T>> resultado) {
        visitados.add(actual);
        resultado.add(actual);

        for (Vertex<T> vecino : matrizAdyacencia.getOrDefault(actual, Collections.emptyMap()).keySet()) {
            if (!visitados.contains(vecino)) {
                dfsRecursivoMatriz(vecino, visitados, resultado);
            }
        }
    }


}
