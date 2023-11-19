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
        graphsController=new GraphsController();
        graphsController.setTypeGraph(1);
        graphsController.addGraph();
    }
    public void testDijkstraWithGraph1() {
        String msg=graphsController.showDistanciasCortas("V1","V4");
        assertNotNull(msg);
    }

    public void testShowConnections() {
        // Configuración del controlador de grafos
        GraphsController graphsController = GraphsController.getInstance();
        graphsController.setTypeGraph(1);
        graphsController.addGraph();

        // Prueba del método showConnections
        String vertice = "V1";
        assertEquals("Conexiones de V1: V2, V3", graphsController.showConnections(vertice));
    }

    // Puedes agregar más casos de prueba según sea necesario
}
