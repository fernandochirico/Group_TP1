
package group.tp;

/**
 *
 * @author GRUPO 13
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Leer {
static String LeerArchivo(String archivo) throws IOException{
   
    String x = "";
    for (String linea : Files.readAllLines(Paths.get(archivo)) ) {
    System.out.println(linea);
    x = x + linea;
    }
    return x;

}

}
