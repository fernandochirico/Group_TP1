
package group.tp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @@author GRUPO 13
 */
public class Ronda {
    
    private String nro;
    List<Partido> PartidosRonda = new ArrayList<Partido>();

    public Ronda(String nro) {
        this.nro = nro;
    }

    public String getNro() {
        return nro;
    }

    public List<Partido> getPartidosRonda() {
        return PartidosRonda;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public void setPartidosRonda(List<Partido> PartidosRonda) {
        this.PartidosRonda = PartidosRonda;
    }

   
    
        
}
