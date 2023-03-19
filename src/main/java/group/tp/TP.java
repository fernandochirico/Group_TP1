
package group.tp;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author GRUPO 13
 */
public class TP {

    public static void main(String[] args) throws IOException {
        
        //En la variable args van a viajar las rutas de los archivos que queremos que abra el programa
        if(args.length == 0){
            System.out.println("ERROR: No ingresaste ningun archivo como argumento! \n Por favor ingresar archivo de PRONOSTICOs y RESULTADOS en ese orden");
            System.exit(88);
        }
              
             String archPronostico = args[0];    
             String archResultado = args[1];
             
        String DatoLeido = "";
        DatoLeido = Leer.LeerArchivo(archPronostico);
        System.out.println(DatoLeido);
    
    }
 }
