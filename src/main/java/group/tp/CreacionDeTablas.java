package group.tp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import persistencia.ConectorSQL;

/**
 *
 * @author fchirico
 */
public class CreacionDeTablas {

    public static void CreacionTablaPronosticos() throws SQLException {

        System.out.println("Comienzo Chequeo tabla pronosticos...");
        Connection conexion = ConectorSQL.getConexion();
        Statement sentencia = null;
        PreparedStatement sentencia2 = null;

        try {
            sentencia = conexion.createStatement();
            String sql;
            sql = "CREATE TABLE IF NOT EXISTS `pronosticos` (\n"
                    + " `idpronostico` int NOT NULL AUTO_INCREMENT,\n"
                    + "  `fase` varchar(1) NOT NULL,\n"
                    + "  `ronda` varchar(1) NOT NULL,\n"
                    + "  `participante` text NOT NULL,\n"
                    + "  `partidoid` varchar(1) NOT NULL,\n"
                    + "  `equipo1` varchar(20) NOT NULL,\n"
                    + "  `gana1` text NOT NULL,\n"
                    + "  `empata` text NOT NULL,\n"
                    + "  `gana2` text NOT NULL,\n"
                    + "  `equipo2` varchar(20) NOT NULL,\n"
                    + " PRIMARY KEY (`idpronostico`)\n"
                    + "); ";
            sentencia.executeUpdate(sql);

            // Chequea si tiene que insertar registros o ya tiene alguno
            sql = "select * from pronosticos;";
            sentencia2 = conexion.prepareStatement(sql);
            ResultSet resultado = sentencia2.executeQuery(sql);

            if (!resultado.next()) {
                System.out.println("Generando registros en tabla pronosticos");
                sql = "INSERT INTO `pronosticos` (`fase`, `ronda`, `participante`, `partidoid`, `equipo1`, `gana1`, `empata`, `gana2`, `equipo2`) VALUES\n"
                        + "('1', '1', 'Mariana', '1', 'Argentina', '', 'x', '', 'Arabia Saudita'),\n"
                        + "('1', '1', 'Mariana', '2', 'Polonia', '', 'x', '', 'Mexico'),\n"
                        + "('1', '1', 'Mariana', '3', 'Argentina', 'x', '', '', 'Mexico'),\n"
                        + "('1', '1', 'Mariana', '4', 'Arabia Saudita', '', '', 'x', 'Polonia'),\n"
                        + "('1', '1', 'Pedro', '1', 'Argentina', 'x', '', '', 'Arabia Saudita'),\n"
                        + "('1', '1', 'Pedro', '2', 'Polonia', '', 'x', '', 'Mexico'),\n"
                        + "('1', '1', 'Pedro', '3', 'Argentina', 'x', '', '', 'Mexico'),\n"
                        + "('1', '1', 'Pedro', '4', 'Arabia Saudita', '', 'x', '', 'Polonia'),\n"
                        + "('1', '2', 'Mariana', '1', 'Argentina', '', 'x', '', 'Arabia Saudita'),\n"
                        + "('1', '2', 'Mariana', '2', 'Polonia', '', 'x', '', 'Mexico'),\n"
                        + "('1', '2', 'Mariana', '3', 'Argentina', 'x', '', '', 'Mexico'),\n"
                        + "('1', '2', 'Mariana', '4', 'Arabia Saudita', '', '', 'x', 'Polonia'),\n"
                        + "('1', '2', 'Pedro', '1', 'Argentina', '', 'x', '', 'Arabia Saudita'),\n"
                        + "('1', '2', 'Pedro', '2', 'Polonia', '', 'x', '', 'Mexico'),\n"
                        + "('1', '2', 'Pedro', '3', 'Argentina', 'x', '', '', 'Mexico'),\n"
                        + "('1', '2', 'Pedro', '4', 'Arabia Saudita', '', '', 'x', 'Polonia'),\n"
                        + "('2', '1', 'Mariana', '1', 'Argentina', 'x', '', '', 'Arabia Saudita'),\n"
                        + "('2', '1', 'Mariana', '2', 'Polonia', '', 'x', '', 'Mexico'),\n"
                        + "('2', '1', 'Mariana', '3', 'Argentina', 'x', '', '', 'Mexico'),\n"
                        + "('2', '1', 'Mariana', '4', 'Arabia Saudita', '', '', 'x', 'Polonia'),\n"
                        + "('2', '1', 'Pedro', '1', 'Argentina', '', 'x', '', 'Arabia Saudita'),\n"
                        + "('2', '1', 'Pedro', '2', 'Polonia', 'x', '', '', 'Mexico'),\n"
                        + "('2', '1', 'Pedro', '3', 'Argentina', 'x', '', '', 'Mexico'),\n"
                        + "('2', '1', 'Pedro', '4', 'Arabia Saudita', 'x', '', '', 'Polonia'),\n"
                        + "('2', '2', 'Mariana', '1', 'Argentina', 'x', '', '', 'Arabia Saudita'),\n"
                        + "('2', '2', 'Mariana', '2', 'Polonia', '', 'x', '', 'Mexico'),\n"
                        + "('2', '2', 'Mariana', '3', 'Argentina', 'x', '', '', 'Mexico'),\n"
                        + "('2', '2', 'Mariana', '4', 'Arabia Saudita', '', '', 'x', 'Polonia'),\n"
                        + "('2', '2', 'Pedro', '1', 'Argentina', '', 'x', '', 'Arabia Saudita'),\n"
                        + "('2', '2', 'Pedro', '2', 'Polonia', 'x', '', '', 'Mexico'),\n"
                        + "('2', '2', 'Pedro', '3', 'Argentina', '', '', 'x', 'Mexico'),\n"
                        + "('2', '2', 'Pedro', '4', 'Arabia Saudita', '', '', 'x', 'Polonia');";
                sentencia.execute(sql);
            }
            // Esto se utiliza par cerrar la conexión con la base de datos
            resultado.close();
            sentencia.close();
            ConectorSQL.cerrarConexion();
        } catch (SQLException se) {
            // Execpción ante problemas de conexión
            se.printStackTrace();
        } finally {
            // Esta sentencia es para que ante un problema con la base igual se cierren las conexiones
            try {
                if (sentencia != null) {
                    sentencia.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Fin Chequeo en tabla pronosticos");
    }
}
