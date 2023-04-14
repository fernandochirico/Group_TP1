package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import group.tp.TP;

/**
 *
 * @author fchirico
 */
public class ConectorSQL {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    // Credenciales credentials
    //  private static Connection conexion = "jdbc:mysql://localhost:3306/prode,root,root"
    /*private static Connection conexion = null;
    private static String nombreDB = "prode";
    private static String host = "localhost";
    private static String puerto = "3306";
    private static String USER = "root";
    private static String PASS = "root";*/
    
    private static Connection conexion = null;
    private static String nombreDB = TP.nombreDB1;
    private static String host = TP.host1;
    private static String puerto = TP.puerto1;
    private static String USER = TP.USER1;
    private static String PASS = TP.PASS1;

    public static Connection getConexion() throws SQLException {
        System.out.println("conectando a la base de datos...");
        if (conexion == null) {
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/" + nombreDB, USER, PASS);
        }
        return conexion;
    }

    public static void cerrarConexion() throws SQLException {
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
            conexion = null;
        }
    }

}
