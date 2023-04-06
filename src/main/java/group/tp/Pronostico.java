package group.tp;

/**
 *
 * @author GRUPO 13
 */
public class Pronostico {

    //private Participante participante;
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;

    public Pronostico( Partido partido, Equipo equipo, ResultadoEnum resultado) {
        
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
        ResultadoEnum resultadoReal = partido.resultado(equipo);
        if (resultado.equals(resultadoReal)) {
            return 1;
        } else {
            return 0;
        }
    }

}
