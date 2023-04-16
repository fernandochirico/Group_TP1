package group.tp;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.opencsv.bean.CsvToBeanBuilder; // Biblioteca para leer un CSV
import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import persistencia.ConectorSQL;

/**
 *
 * @author GRUPO 13
 */
public class TP {

    public static String nombreDB1;
    public static String host1;
    public static String puerto1;
    public static String USER1;
    public static String PASS1;
    public static String puntosPorAcierto;
    public static String puntosPorRonda;
    public static String puntosPorFase;

    public static void main(String[] args) throws SQLException {

        if (args.length == 0) {
            System.out.println("ERROR: No ingresaste ningun archivo como argumento! \n Por favor ingresar archivo de RESULTADOS y CONFIGURACION en ese orden");
            System.exit(88);
        }

        String faseAnterior = "";
        String rondaAnterior = "";
        String participanteAnterior = "";
        int puntosPorRonda = 0;
        int puntosPorParticipante = 0;

        /////////////////////////////////
        // leemos archivo de configuracion
        /////////////////////////////////
        leerArchivoConfiguracion(args[1]);

        // Actualizar tabla prode.configuracion según archivo configuracion.csv
        actualizarTablaConfiguracion();

        // Chequea Creacion tabla 'pronosticos'
        CreacionDeTablas.CreacionTablaPronosticos();

        /////////////////////////////////
        // Leemos archivo de resultados
        /////////////////////////////////
        Collection<Partido> partidos = new ArrayList<Partido>();
        List<Partido> PartidosRondaTemporal = new ArrayList<Partido>();
        System.out.println("\nLectura Archivo Resultados...");
        List<Estructura_Resultado> listaDeResultados;
        try {
            listaDeResultados = new CsvToBeanBuilder(new FileReader(args[0]))
                    .withType(Estructura_Resultado.class)
                    .build()
                    .parse();

            boolean primerLinea = true;
            int i = 0;
            for (Estructura_Resultado l_resultado : listaDeResultados) {
                if (primerLinea) {
                    primerLinea = false;
                } else {
                    i++;
                    if ((l_resultado.getR_rondaNro().isEmpty())
                            || (l_resultado.getR_idPartido().isEmpty())
                            || (l_resultado.getR_equipo1Nombre().isEmpty())
                            || (l_resultado.getR_equipo1Goles().isEmpty())
                            || (l_resultado.getR_equipo2Goles().isEmpty())
                            || (l_resultado.getR_equipo2Nombre().isEmpty())) {
                        System.out.println("Faltan columnas al archivo Resultados, linea: " + (i + 1));
                        System.exit(1);
                    }
//                    System.out.println(l_resultado.getR_rondaNro() + ";" + l_resultado.getR_idPartido() + ";" + l_resultado.getR_equipo1Nombre() + ";" + l_resultado.getR_equipo1Goles()
//                            + ";" + l_resultado.getR_equipo2Goles() + ";" + l_resultado.getR_equipo2Nombre());
                    Equipo equipo1 = new Equipo(l_resultado.getR_equipo1Nombre());
                    Equipo equipo2 = new Equipo(l_resultado.getR_equipo2Nombre());
                    Partido partido = new Partido(equipo1, equipo2);
                    try {
                        partido.setGolesEquipo1(Integer.parseInt(l_resultado.getR_equipo1Goles()));
                    } catch (NumberFormatException e) {
                        System.out.println("Error de formato numérico en el campo de GOLES EQUIPO 1 " + e.getMessage());
                        System.exit(1);
                    }
                    try {
                        partido.setGolesEquipo2(Integer.parseInt(l_resultado.getR_equipo2Goles()));
                    } catch (NumberFormatException e) {
                        System.out.println("Error de formato numérico en el campo de GOLES EQUIPO 2 " + e.getMessage());
                        System.exit(1);
                    }
                    partido.setRondaNro(l_resultado.getR_rondaNro());
                    partido.setIdPartido(l_resultado.getR_idPartido());
                    partidos.add(partido);

                    Ronda ronda = new Ronda(l_resultado.getR_rondaNro());
                    PartidosRondaTemporal.add(partido);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("El archivo de RESULTADOS no pudo leerse correctamente.");
            System.exit(1);
        }

        /////////////////////////////////
        // leemos archivo de pronosticos
        /////////////////////////////////
        System.out.println("\nLectura tabla prode.pronosticos...");
        try {
            Connection conexion = ConectorSQL.getConexion();
            PreparedStatement sentenciaDeBusqueda = conexion.prepareStatement("SELECT * FROM pronosticos order by fase,ronda,participante;");
            ResultSet resultado = sentenciaDeBusqueda.executeQuery();

            int puntos = 0; // puntos por persona
            boolean primerRegistroFase = true;
            boolean primerRegistroRonda = true;
            boolean primerRegistroParticipante = true;
            Map<String, Integer> puntosTotalPorParticipante = new HashMap<>();

            while (resultado.next()) {
                if (primerRegistroFase) {
                    faseAnterior = resultado.getString("fase");
                    primerRegistroFase = false;
                }
                if (primerRegistroRonda) {
                    rondaAnterior = resultado.getString("ronda");
                    primerRegistroRonda = false;
                }
                if (primerRegistroParticipante) {
                    participanteAnterior = resultado.getString("participante");
                    primerRegistroParticipante = false;
                }

                Equipo equipo1 = new Equipo(resultado.getString("equipo1"));
                Equipo equipo2 = new Equipo(resultado.getString("equipo2"));
                Partido partido = null;
                // identifico el partido que estoy leyendo en este registro y
                // le paso partido al constructor de la clase Partido
                for (Partido coleccionPartido : partidos) {
                    if (coleccionPartido.getEquipo1().getNombre().equals(equipo1.getNombre())
                            && coleccionPartido.getEquipo2().getNombre().equals(equipo2.getNombre())
                            && coleccionPartido.getRondaNro().equals(resultado.getString("ronda"))) {

                        partido = coleccionPartido;
                    }
                }
                // le paso ResultadoEnum al constructor de la clase Partido
                Equipo equipo = null;
                ResultadoEnum resultadoPronosticado = null;
                if ((resultado.getString("gana1").toUpperCase()) == "X") {
                    equipo = equipo1;
                    resultadoPronosticado = ResultadoEnum.GANADOR;
                } else {
                    if (resultado.getString("gana2").toUpperCase() == "X") {
                        equipo = equipo1;
                        resultadoPronosticado = ResultadoEnum.PERDEDOR;
                    } else {
                        equipo = equipo1;
                        resultadoPronosticado = ResultadoEnum.EMPATE;
                    }
                }
                Pronostico pronostico = new Pronostico(resultado.getString("fase"), resultado.getString("ronda"), partido, equipo, resultadoPronosticado);
                // sumo puntos 
                if (resultado.getString("fase").equals(faseAnterior)) {
                    if (resultado.getString("ronda").equals(rondaAnterior)) {
                        if (resultado.getString("participante").equals(participanteAnterior)) {
                            puntos = puntos + pronostico.puntos();
                        } else {
                            // muestro puntos por cambio de Participante
                            puntosTotalPorParticipante.put(participanteAnterior, puntosTotalPorParticipante.getOrDefault(participanteAnterior, 0) + puntos);
                            muestroPuntos(faseAnterior, rondaAnterior, participanteAnterior, puntos);
                            participanteAnterior = resultado.getString("participante");
                            puntos = 0;
                            puntos = puntos + pronostico.puntos();
                        }
                    } else {
                        // muestro puntos por cambio de Ronda
                        puntosTotalPorParticipante.put(participanteAnterior, puntosTotalPorParticipante.getOrDefault(participanteAnterior, 0) + puntos);
                        muestroPuntos(faseAnterior, rondaAnterior, participanteAnterior, puntos);
                        rondaAnterior = resultado.getString("ronda");
                        participanteAnterior = resultado.getString("participante");
                        puntos = 0;
                        puntos = puntos + pronostico.puntos();
                    }
                } else {
                    // muestro puntos por cambio de Fase
                    puntosTotalPorParticipante.put(participanteAnterior, puntosTotalPorParticipante.getOrDefault(participanteAnterior, 0) + puntos);
                    muestroPuntos(faseAnterior, rondaAnterior, participanteAnterior, puntos);
                    faseAnterior = resultado.getString("fase");
                    rondaAnterior = resultado.getString("ronda");
                    participanteAnterior = resultado.getString("participante");
                    puntos = 0;
                    puntos = puntos + pronostico.puntos();
                }

            }
            // muestro puntos
            puntosTotalPorParticipante.put(participanteAnterior, puntosTotalPorParticipante.getOrDefault(participanteAnterior, 0) + puntos);
            muestroPuntos(faseAnterior, rondaAnterior, participanteAnterior, puntos);
            System.out.println("=======================================================");
            puntosTotalPorParticipante.forEach((k, v) -> {
                System.out.println("Participante: " + k + ", Total de Puntos: " + v);
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("La tabla de PRONOSTICOS no pudo leerse correctamente.");
            System.exit(1);
        }
    }

    public static void muestroPuntos(String faseAnterior, String rondaAnterior, String participanteAnterior, int puntos) {
        System.out.println("\nLos puntos obtenidos en la FASE" + faseAnterior + " RONDA " + rondaAnterior + " por el PARTICIPANTE "
                + participanteAnterior + " fueron: " + puntos);
    }

    public static void leerArchivoConfiguracion(String archivo) {
        Path pathconfiguracion = Paths.get(archivo);
        List<String> lineasConfiguracion = null;
        try {
            lineasConfiguracion = Files.readAllLines(pathconfiguracion);
        } catch (IOException e) {
            System.out.println("No se pudo leer la linea del archivo de configuracion...");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        for (String lineaConfiguracion : lineasConfiguracion) {
            String[] campos = lineaConfiguracion.split(",");
            host1 = campos[0];
            puerto1 = campos[1];
            nombreDB1 = campos[2];
            USER1 = campos[3];
            PASS1 = campos[4];
            puntosPorAcierto = campos[5];
            puntosPorRonda = campos[6];
            puntosPorFase = campos[7];
        }
    }

    public static void actualizarTablaConfiguracion() throws SQLException {
        Connection conexion = ConectorSQL.getConexion();
        Statement sentencia = null;
        try {
            sentencia = conexion.createStatement();
            String sql;
            sql = "update configuracion set puntos ='" + puntosPorAcierto + "' where concepto = 'ACIERTO';";
            sentencia.executeUpdate(sql);
            sql = "update configuracion set puntos ='" + puntosPorRonda + "' where concepto = 'RONDA';";
            sentencia.executeUpdate(sql);
            sql = "update configuracion set puntos ='" + puntosPorFase + "' where concepto = 'FASE';";
            sentencia.executeUpdate(sql);
            sentencia.close();
            ConectorSQL.cerrarConexion();
        } catch (SQLException se) {
            // Execpción ante problemas de conexión
            se.printStackTrace();
        }
    }
}
