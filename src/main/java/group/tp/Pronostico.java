package group.tp;

/**
 *
 * @author GRUPO 13
 */
public class Pronostico {
    int idPronostico;
    Partido partido = new Partido();
    Equipo equipo1 = new Equipo();
    Equipo equipo2 = new Equipo();
    char gana1;
    char empata;
    char gana2;
    
    public Pronostico() {
    }

    public Pronostico(int idPronostico, char gana1, char empata, char gana2) {
        this.idPronostico = idPronostico;
        this.gana1 = gana1;
        this.empata = empata;
        this.gana2 = gana2;
    }

    
}
