package group.tp;

/**
 *
 * @author GRUPO 13
 */
public class Pronostico extends Partido {
    int idPronostico;
    Partido partido = new Partido();
    Equipo equipo1 = new Equipo();
    Equipo equipo2 = new Equipo();
    char gana1;
    char empata;
    char gana2;
    
    public Pronostico() {
    }

    public Pronostico(int idPronostico, char gana1, char empata, char gana2, int idPartido, int golesEquipo1, int golesEquipo2, int idEquipo, String nombre, String descripcion) {
        super(idPartido, golesEquipo1, golesEquipo2, idEquipo, nombre, descripcion);
        this.idPronostico = idPronostico;
        this.gana1 = gana1;
        this.empata = empata;
        this.gana2 = gana2;
    }



    
}
