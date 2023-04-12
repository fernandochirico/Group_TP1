/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package group.tp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import static org.junit.Assert.*;

import static persistencia.ConectorSQL.DB_URL;
import static persistencia.ConectorSQL.PASS;
import static persistencia.ConectorSQL.USER;

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

    @Test
    public void testconexionMySQL() {
        Connection conexion = null;
        Statement consulta = null;

        try {

            // Abrir la conexión
            System.out.println("conectando a la base de datos...");

            conexion = DriverManager.getConnection(DB_URL, USER, PASS);

            // Ejecutar una consulta
            System.out.println("Creando statement...");
            consulta = conexion.createStatement();
            String sql;
            sql = "SELECT concepto,puntos,observacion FROM prode.configuracion";

            //En la variable resultado obtendremos las distintas filas que nos devolvió la base
            ResultSet resultado = consulta.executeQuery(sql);

            // Obtener las distintas filas de la consulta
            while (resultado.next()) {
                // Obtener el valor de cada columna
                String concepto = resultado.getString("concepto");
                int puntos = resultado.getInt("puntos");
                String observacion = resultado.getString("observacion");

                // Mostrar los valores obtenidos
                System.out.print("Concepto " +concepto);
                System.out.print(", Puntos: " + puntos);
                System.out.println(", Observacion: " + observacion);
            }
            // Esto se utiliza par cerrar la conexión con la base de datos
            resultado.close();
            consulta.close();
            conexion.close();
        } catch (SQLException se) {
            // Execpción ante problemas de conexión
            se.printStackTrace();
        } finally {
            // Esta sentencia es para que ante un problema con la base igual se cierren las conexiones
            try {
                if (consulta != null)
                    consulta.close();
            } catch (SQLException se2) {
            }
            try {
                if (conexion != null)
                    conexion.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Fin de la ejecucción");
        
    }
}
