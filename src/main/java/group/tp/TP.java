package group.tp;

import com.opencsv.bean.CsvToBeanBuilder; // Biblioteca para leer un CSV
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author GRUPO 13
 */
public class TP {

    public static void main(String[] args) {

        //En la variable args van a viajar las rutas de los archivos que queremos que abra el programa
        if (args.length == 0) {
            System.out.println("ERROR: No ingresaste ningun archivo como argumento! \n Por favor ingresar archivo de RESULTADOS y PRONOSTICOS en ese orden");
            System.exit(88);
        }

        List <Estructura_Resultado> listaDeREsultados;
        try {
            // En esta primera linea definimos el archivos que va a ingresar
            listaDeREsultados = new CsvToBeanBuilder(new FileReader(args[0]))
                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(Estructura_Resultado.class)
                    .build()
                    .parse();

            //El resultado de este metodo nos da una lista del objeto
            /*for (Estructura_Resultado l_resultado : listaDeREsultados) {
                System.out.println( l_resultado.getR_idPartido()+ ";" + l_resultado.getR_idequipo1() + ";"
                        + l_resultado.getR_equipo1Nombre()+ ";" + l_resultado.getR_equipo2Descripcion()+ ";" + l_resultado.getR_equipo1Goles() +
                        ";" + l_resultado.getR_equipo2Goles() + ";" + l_resultado.getR_idequipo2() + ";" + l_resultado.getR_equipo2Nombre() + ";"
                        + l_resultado.getR_equipo2Descripcion()  );
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }

        List <Estructura_Pronostico> listaDePronosticos;
        try {
            // En esta primera linea definimos el archivos que va a ingresar
            listaDePronosticos = new CsvToBeanBuilder(new FileReader(args[1]))
                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(Estructura_Pronostico.class)
                    .build()
                    .parse();

            //El resultado de este metodo nos da una lista del objeto
            for (Estructura_Pronostico l_pronostico : listaDePronosticos) {
                System.out.println(l_pronostico.getP_idPronostico() + ";" + l_pronostico.getP_idPartido() + ";"
                        + l_pronostico.getP_idEquipo1() + ";" + l_pronostico.getP_gana1() + ";" + l_pronostico.getP_gana2() +
                        ";" + l_pronostico.getP_empata() + ";" + l_pronostico.getP_idEquipo2());
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        // mostrar puntos del participante
    }
}
