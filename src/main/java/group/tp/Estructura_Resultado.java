package group.tp;

import com.opencsv.bean.CsvBindByPosition;

/**
 *
 * @author GRUPO 13
 */
public class Estructura_Resultado {

    @CsvBindByPosition(position = 0)
    private Integer r_idRonda;
    @CsvBindByPosition(position = 1)
    private Integer r_idPartido;
    @CsvBindByPosition(position = 2)
    private Integer r_idequipo1;
    @CsvBindByPosition(position = 3)
    private String r_equipo1Nombre;
    @CsvBindByPosition(position = 4)
    private String r_equipo1Descripcion;
    @CsvBindByPosition(position = 5)
    private Integer r_equipo1Goles;
    @CsvBindByPosition(position = 6)
    private Integer r_equipo2Goles;
    @CsvBindByPosition(position = 7)
    private Integer r_idequipo2;
    @CsvBindByPosition(position = 8)
    private String r_equipo2Nombre;
    @CsvBindByPosition(position = 9)
    private String r_equipo2Descripcion;

    
   // Getters
    
    public Integer getR_idRonda() {
        return r_idRonda;
    }

    public Integer getR_idPartido() {
        return r_idPartido;
    }

    public Integer getR_idequipo1() {
        return r_idequipo1;
    }

    public String getR_equipo1Nombre() {
        return r_equipo1Nombre;
    }

    public String getR_equipo1Descripcion() {
        return r_equipo1Descripcion;
    }

    public Integer getR_equipo1Goles() {
        return r_equipo1Goles;
    }

    public Integer getR_equipo2Goles() {
        return r_equipo2Goles;
    }

    public Integer getR_idequipo2() {
        return r_idequipo2;
    }

    public String getR_equipo2Nombre() {
        return r_equipo2Nombre;
    }

    public String getR_equipo2Descripcion() {
        return r_equipo2Descripcion;
    }

    // Setters
    
    public void setR_idRonda(Integer r_idRonda) {
        this.r_idRonda = r_idRonda;
    }

    public void setR_idPartido(Integer r_idPartido) {
        this.r_idPartido = r_idPartido;
    }

    public void setR_idequipo1(Integer r_idequipo1) {
        this.r_idequipo1 = r_idequipo1;
    }

    public void setR_equipo1Nombre(String r_equipo1Nombre) {
        this.r_equipo1Nombre = r_equipo1Nombre;
    }

    public void setR_equipo1Descripcion(String r_equipo1Descripcion) {
        this.r_equipo1Descripcion = r_equipo1Descripcion;
    }

    public void setR_equipo1Goles(Integer r_equipo1Goles) {
        this.r_equipo1Goles = r_equipo1Goles;
    }

    public void setR_equipo2Goles(Integer r_equipo2Goles) {
        this.r_equipo2Goles = r_equipo2Goles;
    }

    public void setR_idequipo2(Integer r_idequipo2) {
        this.r_idequipo2 = r_idequipo2;
    }

    public void setR_equipo2Nombre(String r_equipo2Nombre) {
        this.r_equipo2Nombre = r_equipo2Nombre;
    }

    public void setR_equipo2Descripcion(String r_equipo2Descripcion) {
        this.r_equipo2Descripcion = r_equipo2Descripcion;
    }
 
    
    
}