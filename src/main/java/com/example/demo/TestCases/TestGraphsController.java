package com.example.demo.TestCases;

import com.example.demo.controllers.GraphsController;
import junit.framework.TestCase;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class TestGraphsController extends TestCase {
    private GraphsController graphsController;

    @Before
    public void setUp() {
        graphsController = GraphsController.getInstance();
        graphsController.setTypeGraph(1);
    }

    @Test
    void showConextionsGraph1Test() {
        graphsController.setTypeGraph(1);
        graphsController.addVertex();
        String result = graphsController.showConextions();
        // Puedes agregar aserciones según tus necesidades para verificar el comportamiento esperado
        // Aquí solo se verifica que el método no lance excepciones.
        assertNotNull(result);
    }
}
