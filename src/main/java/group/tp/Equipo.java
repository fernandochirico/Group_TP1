package group.tp;

/**
 *
 * @author GRUPO 13
 */
public class Equipo {

    private int idEquipo;
    private String nombre;
    private String descripcion;

    public Equipo() {
    }

    public Equipo(int idEquipo, String nombre, String descripcion) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters

    public int getIdEquipo() {
        return idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
}
