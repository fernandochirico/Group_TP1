package group.tp;

/**
 *
 * @author GRUPO 13
 */
public class Pronostico extends Equipo {
    private int idPronostico;
    private int idPartido;
    private int idEquipo;
    private char gana1;
    private char empata;
    private char gana2;
    
    public Pronostico() {
    }

    public Pronostico(int idPronostico, int idPartido, int idEquipo, char gana1, char empata, char gana2) {
        this.idPronostico = idPronostico;
        this.idPartido = idPartido;
        this.idEquipo = idEquipo;
        this.gana1 = gana1;
        this.empata = empata;
        this.gana2 = gana2;
    }



    
}
