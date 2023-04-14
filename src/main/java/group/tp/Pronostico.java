package group.tp;

import group.tp.TP;
/**
 *
 * @author GRUPO 13
 */
public class Pronostico {

    //private Participante participante;
    
    private String rondaPronostico;
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;

    public Pronostico( String rondaPronostico,Partido partido, Equipo equipo, ResultadoEnum resultado) {
        this.rondaPronostico = rondaPronostico;
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
            return Integer.parseInt(TP.puntosPorAcierto);
        } else {
            return 0;
        }
    }

}
