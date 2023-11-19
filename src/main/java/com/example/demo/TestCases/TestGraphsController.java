package com.example.demo.TestCases;
import com.example.demo.ClasesGrafos.Vertex;
import com.example.demo.controllers.GraphsController;
import java.util.ArrayList;
import java.util.List;
public class TestGrapshController extends TestCase{

    @Test
    public void testShowConnectionsGraph1BFS() {
        GraphsController graphsController = GraphsController.getInstance();
        graphsController.setTypeGraph(1);

        // Agregar vértices de ejemplo
        graphsController.addVertex();

        // Obtener una combinación de vértices para realizar la prueba
        ArrayList<String> combinaciones = graphsController.getCombinaciones();
        String nombreVertice = combinaciones.get(0);

        // Mostrar conexiones con BFS
        graphsController.showConnectionsGraph1BFS(nombreVertice);
    }
}
