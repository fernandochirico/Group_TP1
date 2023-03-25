package group.tp;

/**
 *
 * @author GRUPO 13
 */
public class Partido extends Equipo {

    private int idPartido;
    private int idEquipoUno;
    private int idEquipoDos;
    private int golesEquipo1;
    private int golesEquipo2;

    public Partido() {
    }

    public Partido(int idPartido, int idEquipoUno, int idEquipoDos, int golesEquipo1, int golesEquipo2) {
        this.idPartido = idPartido;
        this.idEquipoUno = idEquipoUno;
        this.idEquipoDos = idEquipoDos;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

}
