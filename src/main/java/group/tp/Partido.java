package group.tp;

/**
 *
 * @author GRUPO 13
 */
public class Partido {

    private String faseNro;
    private String rondaNro;
    private String idPartido;
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public Partido(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public Partido(String faseNro, String rondaNro, String idPartido) {
        this.rondaNro = faseNro;
        this.rondaNro = rondaNro;
        this.idPartido = idPartido;
    }

    public String getFaseNro() {
        return faseNro;
    }

    public String getRondaNro() {
        return rondaNro;
    }

    public String getIdPartido() {
        return idPartido;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setFaseNro(String faseNro) {
        this.faseNro = faseNro;
    }

    public void setRondaNro(String rondaNro) {
        this.rondaNro = rondaNro;
    }

    public void setIdPartido(String idPartido) {
        this.idPartido = idPartido;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public ResultadoEnum resultado(Equipo equipo) {
        if (golesEquipo1 == golesEquipo2) {
            return ResultadoEnum.EMPATE;
        }
        if (equipo.getNombre().equals(equipo1.getNombre())) {
            if (golesEquipo1 > golesEquipo2) {
                return ResultadoEnum.GANADOR;
            } else {
                return ResultadoEnum.PERDEDOR;
            }
        } else {
            // como equipo no es equipo1, entonces es equipo2
            if (golesEquipo2 > golesEquipo1) {
                return ResultadoEnum.GANADOR;
            } else {
                return ResultadoEnum.PERDEDOR;
            }
        }
    }
}
