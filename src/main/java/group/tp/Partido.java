
package group.tp;

/**
 *
 * @author GRUPO 13
 */
public class Partido extends Equipo{
 
    int idPartido;
    Equipo equipo1 = new Equipo();
    Equipo equipo2 = new Equipo();
    int golesEquipo1;
    int golesEquipo2;

    public Partido() {
    }

    public Partido(int idPartido, int golesEquipo1, int golesEquipo2, int idEquipo, String nombre, String descripcion) {
        super(idEquipo, nombre, descripcion);
        this.idPartido = idPartido;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }
    
    }
