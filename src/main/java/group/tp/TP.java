package group.tp;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.opencsv.bean.CsvToBeanBuilder; // Biblioteca para leer un CSV
import java.util.Collection;
import java.util.ArrayList;

/**
 *
 * @author GRUPO 13
 */
public class TP {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("ERROR: No ingresaste ningun archivo como argumento! \n Por favor ingresar archivo de RESULTADOS y PRONOSTICOS en ese orden");
            System.exit(88);
        }

        String rondaAnterior = "";
        String participanteAnterior = "";
        int puntosPorRonda = 0;
        int puntosPorParticipante = 0;

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
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("El archivo de RESULTADOS no pudo leerse correctamente.");
            System.exit(1);
                }  

      
        /////////////////////////////////
        // leemos archivo de pronosticos
        /////////////////////////////////
        System.out.println("\nLectura Archivo Pronosticos...");
        List<Estructura_Pronostico> listaDePronosticos;
        try {
            listaDePronosticos = new CsvToBeanBuilder(new FileReader(args[1]))
                    .withType(Estructura_Pronostico.class)
                    .build()
                    .parse();
            boolean primerLinea = true;
            int puntos = 0; // puntos por persona
            boolean primerRegistroRonda = true;
            boolean primerRegistroParticipante = true;
            for (Estructura_Pronostico l_pronostico : listaDePronosticos) {
                if (primerLinea) {
                    primerLinea = false;
                } else {
                    if (primerRegistroRonda) {
                        rondaAnterior = l_pronostico.getP_ronda();
                        primerRegistroRonda = false;
                    }
                    if (primerRegistroParticipante) {
                        participanteAnterior = l_pronostico.getP_participanteNombre();
                        primerRegistroParticipante = false;
                    }
//                    System.out.println(l_pronostico.getP_ronda() + ";" + l_pronostico.getP_participanteNombre() + ";" + l_pronostico.getP_idPartido() + ";" + l_pronostico.getP_Equipo1() + ";" + l_pronostico.getP_gana1()
//                            + ";" + l_pronostico.getP_empata()
//                            + ";" + l_pronostico.getP_gana2() + ";" + l_pronostico.getP_Equipo2());

                    Equipo equipo1 = new Equipo(l_pronostico.getP_Equipo1());
                    Equipo equipo2 = new Equipo(l_pronostico.getP_Equipo2());
                    Partido partido = null;

                    // identifico el partido que estoy leyendo en este registro y
                    // le paso partido al constructor de la clase Partido
                    for (Partido coleccionPartido : partidos) {
                        if (coleccionPartido.getEquipo1().getNombre().equals(equipo1.getNombre())
                                && coleccionPartido.getEquipo2().getNombre().equals(equipo2.getNombre())
                                && coleccionPartido.getRondaNro().equals(l_pronostico.getP_ronda())) {

                            partido = coleccionPartido;
                        }
                    }

                    // le paso ResultadoEnum al constructor de la clase Partido
                    Equipo equipo = null;
                    ResultadoEnum resultadoPronosticado = null;
                    if (Character.toUpperCase(l_pronostico.getP_gana1()) == 'X') {
                        equipo = equipo1;
                        resultadoPronosticado = ResultadoEnum.GANADOR;
                    } else {
                        if (Character.toUpperCase(l_pronostico.getP_gana2()) == 'X') {
                            equipo = equipo1;
                            resultadoPronosticado = ResultadoEnum.PERDEDOR;
                        } else {
                            equipo = equipo1;
                            resultadoPronosticado = ResultadoEnum.EMPATE;
                        }
                    }

                    Pronostico pronostico = new Pronostico(l_pronostico.getP_ronda(), partido, equipo, resultadoPronosticado);
                    // sumo puntos 
                    if (l_pronostico.getP_ronda().equals(rondaAnterior)) {
                        if (l_pronostico.getP_participanteNombre().equals(participanteAnterior)) {
                            puntos = puntos + pronostico.puntos();
                        } else {
                            // muestro puntos por cambio de Participante
                            muestroPuntos(rondaAnterior, participanteAnterior, puntos);
                            participanteAnterior = l_pronostico.getP_participanteNombre();
                            puntos = 0;
                            puntos = puntos + pronostico.puntos();
                        }
                    } else {
                        // muestro puntos por cambio de Ronda
                        muestroPuntos(rondaAnterior, participanteAnterior, puntos);
                        rondaAnterior = l_pronostico.getP_ronda();
                        participanteAnterior = l_pronostico.getP_participanteNombre();
                        puntos = 0;
                        puntos = puntos + pronostico.puntos();
                    }
                }
            }
            // muestro puntos
            muestroPuntos(rondaAnterior, participanteAnterior, puntos);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("El archivo de PRONOSTICOS no pudo leerse correctamente.");
            System.exit(1);
        }
    }

    public static void muestroPuntos(String rondaAnterior, String participanteAnterior, int puntos) {
        System.out.println("\nLos puntos obtenidos en la RONDA " + rondaAnterior + " por el PARTICIPANTE "
                + participanteAnterior + " fueron: " + puntos);
    }
}
