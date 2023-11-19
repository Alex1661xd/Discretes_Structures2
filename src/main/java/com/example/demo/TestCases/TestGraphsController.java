package com.example.demo.TestCases;

import com.example.demo.controllers.GraphsController;
import junit.framework.TestCase;

import java.util.ArrayList;


public class TestGraphsController extends TestCase {

    public void testShowConnectionsGraph1BFS() {
        GraphsController graphsController = GraphsController.getInstance();
        graphsController.setTypeGraph(1);
        ArrayList<String> combinaciones = graphsController.getCombinaciones();
        String nombreVertice = combinaciones.get(0);
        // Agregar vértices de ejemplo
        graphsController.addVertex();

        // Mostrar conexiones con BFS
        graphsController.showConnectionsGraph1BFS(nombreVertice);
    }
}
