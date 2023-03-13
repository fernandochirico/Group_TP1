
package group.tp;

import java.io.IOException;

/**
 *
 * @author GRUPO 13
 */
public class TP {

    public static void main(String[] args) throws IOException {
        String archPronostico = "C:\\Curso_Java\\Trabajo_Integrador_comision_144\\Primera_Entrega\\pronostico.csv";    
        String archResultados = "C:\\Curso_Java\\Trabajo_Integrador_comision_144\\Primera_Entrega\\resultados.csv";
        String DatoLeido = "";
        DatoLeido = Leer.LeerArchivo(archPronostico);
        System.out.println(DatoLeido);
    
    }
 }
