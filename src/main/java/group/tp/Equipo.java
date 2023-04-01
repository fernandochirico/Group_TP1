package group.tp;

/**
 *
 * @author GRUPO 13
 */
public class Equipo {

    private String nombre;
    private String descripcion;

    public Equipo(String nombre) {
        this.nombre = nombre;
         }

    // Getters

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
