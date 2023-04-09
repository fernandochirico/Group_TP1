/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package group.tp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fchirico
 */
public class TPTest {

   // private int puntos;

    @BeforeEach
    public void inicializar() {
        // puntos = 10;
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = new String[2];
        args[0] = "c:\\Curso_Java\\UTN_TP\\Group_TP1\\src\\recursos\\resultados.csv";
        args[1] = "c:\\Curso_Java\\UTN_TP\\Group_TP1\\src\\recursos\\pronostico_test_entrega2.csv";
        TP.main(args);

        //Assert.assertEquals(3, puntos );
         }

}
