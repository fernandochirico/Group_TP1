/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package group.tp;

import com.opencsv.bean.CsvToBeanBuilder;
import static group.tp.TP.muestroPuntos;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fchirico
 */
public class TPTest {

    public TPTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class TP.
     */
    @Test
    public void testMain()  {
        System.out.println("main");
        String[] args = new String[2];
        args[0]="c:\\Curso_Java\\UTN_TP\\Group_TP1\\src\\recursos\\resultados.csv";
        args[1]="c:\\Curso_Java\\UTN_TP\\Group_TP1\\src\\recursos\\pronostico_test_entrega2.csv";
        TP.main(args);
        
        String rondaAnterior = "1";
        String participanteAnterior = "Mariana";
        int puntos = 0;
        muestroPuntos(rondaAnterior, participanteAnterior, puntos);
        Assert.assertEquals(3, puntos);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
