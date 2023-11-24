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

    // Puedes agregar más casos de prueba según sea necesario
}
