package group.tp;

/**
 *
 * @author GRUPO 13
 */
public class Pronostico {

    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;

    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }

    public Partido getPartido() {
        return partido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public int puntos() {
        int puntos = 0;
        ResultadoEnum resultadoReal = partido.resultado(equipo);
        
        return puntos;
    }

}
