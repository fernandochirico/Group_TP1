package group.tp;

/**
 *
 * @author GRUPO 13
 */
public class Pronostico  {
    private int idPronostico;
    private Partido partido;
    private Equipo  equipo;
    private char gana1;
    private char empata;
    private char gana2;
    private ResultadoEnum resultado;
    
    public Pronostico() {
    }

    public Pronostico(int idPronostico, Partido partido, Equipo equipo, char gana1, char empata, char gana2) {
        this.idPronostico = idPronostico;
        this.partido = partido;
        this.equipo = equipo;
        this.gana1 = gana1;
        this.empata = empata;
        this.gana2 = gana2;
    }


public int puntos(){
    int puntos = 0;
    return puntos;
}
   
}
