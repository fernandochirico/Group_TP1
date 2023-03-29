package group.tp;

/**
 *
 * @author GRUPO 13
 */
public class Partido {

    private int idPartido;
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    public Partido(int idPartido, Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.idPartido = idPartido;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public String resultado(Equipo equipo) {
        String ResultadoEnum = "";
        return ResultadoEnum;
    }
}
