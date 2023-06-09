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
        /////////////////////////////////
        // Leemos archivo de resultados
        /////////////////////////////////
        Collection<Partido> partidos = new ArrayList<Partido>();
        System.out.println("\nLectura Archivo Resultados...");
        List<Estructura_Resultado> listaDeResultados;
        try {
            listaDeResultados = new CsvToBeanBuilder(new FileReader(args[0]))
                    .withType(Estructura_Resultado.class)
                    .build()
                    .parse();
            boolean primerLinea = true;
            for (Estructura_Resultado l_resultado : listaDeResultados) {
                if (primerLinea) {
                    primerLinea = false;
                } else {
                    System.out.println(l_resultado.getR_equipo1Nombre() + ";" + l_resultado.getR_equipo1Goles()
                            + ";" + l_resultado.getR_equipo2Goles() + ";" + l_resultado.getR_equipo2Nombre());

                    Equipo equipo1 = new Equipo(l_resultado.getR_equipo1Nombre());
                    Equipo equipo2 = new Equipo(l_resultado.getR_equipo2Nombre());
                    Partido partido = new Partido(equipo1, equipo2);
                    partido.setGolesEquipo1(Integer.parseInt(l_resultado.getR_equipo1Goles()));
                    partido.setGolesEquipo2(Integer.parseInt(l_resultado.getR_equipo2Goles()));
                    partidos.add(partido);
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
        System.out.println("\nLectura Archivo Pronosticos...");
        List<Estructura_Pronostico> listaDePronosticos;
        try {
            listaDePronosticos = new CsvToBeanBuilder(new FileReader(args[1]))
                    .withType(Estructura_Pronostico.class)
                    .build()
                    .parse();
            boolean primerLinea = true;
            int puntos = 0; // puntos por persona
            for (Estructura_Pronostico l_pronostico : listaDePronosticos) {
                if (primerLinea) {
                    primerLinea = false;
                } else {
                    System.out.println(l_pronostico.getP_Equipo1() + ";" + l_pronostico.getP_gana1()
                            + ";" + l_pronostico.getP_empata()
                            + ";" + l_pronostico.getP_gana2() + ";" + l_pronostico.getP_Equipo2());

                    Equipo equipo1 = new Equipo(l_pronostico.getP_Equipo1());
                    Equipo equipo2 = new Equipo(l_pronostico.getP_Equipo2());
                    Partido partido = null;

                    // identifico el partido que estoy leyendo en este registro y
                    // le paso partido al constructor de la clase Partido
                    for (Partido coleccionPartido : partidos) {
                        if (coleccionPartido.getEquipo1().getNombre().equals(equipo1.getNombre())
                                && coleccionPartido.getEquipo2().getNombre().equals(equipo2.getNombre())) {

                            partido = coleccionPartido;
                        }

                    }

                    // le paso ResultadoEnum al constructor de la clase Partido
                    Equipo equipo = null;
                    ResultadoEnum resultadoPronosticado = null;
                    if (Character.toUpperCase(l_pronostico.getP_gana1() ) == 'X') {
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

                    Pronostico pronostico = new Pronostico(partido, equipo, resultadoPronosticado);
                    // sumo puntos 
                    puntos = puntos + pronostico.puntos();
                }
            }
             // muestro puntos
             System.out.println("\nLos puntos obtenidos por la persona fueron:" + puntos );
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("El archivo de PRONOSTICOS no pudo leerse correctamente.");
            System.exit(1);
        }
    }
}
