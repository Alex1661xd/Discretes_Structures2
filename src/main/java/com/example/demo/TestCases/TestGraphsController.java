package com.example.demo.TestCases;

import com.example.demo.ClasesGrafos.Graph1;
import com.example.demo.controllers.GraphsController;
import junit.framework.TestCase;
import org.junit.Before;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

public class TestGraphsController extends TestCase {
    GraphsController graphsController;
    @Before
    public void setUp(){
        graphsController=GraphsController.getInstance();
        graphsController.setTypeGraph(2);
        graphsController.addGraph();
    }
    public void testShowConnections() {
        // Configuración del controlador de grafos
        GraphsController graphsController = GraphsController.getInstance();
        graphsController.setTypeGraph(2);
        graphsController.addGraph();

        // Prueba del método showConnections
        String vertice = "V2";
        String msg=graphsController.showConnections(vertice);
        assertEquals("Conexiones de V2: V4", graphsController.showConnections(vertice));
    }


    public void testGetInstance() {
        GraphsController instance1 = GraphsController.getInstance();
        GraphsController instance2 = GraphsController.getInstance();

        // Verificar que ambas instancias sean la misma instancia
        assertSame(instance1, instance2);
    }


    public void testAddGraph1() {
        GraphsController graphController = GraphsController.getInstance();
        graphController.setTypeGraph(1);

        // Asegurarse de que no haya excepciones al agregar el grafo 1
        assertDoesNotThrow(() -> graphController.addGraph());
    }


    public void testAddGraph2() {
        GraphsController graphController = GraphsController.getInstance();
        graphController.setTypeGraph(2);

        // Asegurarse de que no haya excepciones al agregar el grafo 2
        assertDoesNotThrow(() -> graphController.addGraph());
    }


    public void testShowDistanciasCortas() {
        GraphsController graphController = GraphsController.getInstance();
        graphController.setTypeGraph(1);

        // Agregar nodos y conexiones al grafo1
        graphController.addGraph();

        // Asegurarse de que la distancia corta sea un número no negativo
        int distancia = graphController.showDistanciasCortas("A", "B");
        assertTrue(distancia >= 0);
    }


}
