package group.tp;

import com.opencsv.bean.CsvBindByPosition;

/**
 *
 * @author GRUPO 13
 */
public class Estructura_Resultado {

    /*
    @CsvBindByPosition(position = 0)
    private String r_Filler;
    @CsvBindByPosition(position = 1)
    private Integer r_idRonda;
    @CsvBindByPosition(position = 2)
    private Integer r_idPartido;
    @CsvBindByPosition(position = 3)
    private Integer r_idequipo1;
    */
    
    //@CsvBindByPosition(position = 0)
    //private String r_filler;
    @CsvBindByPosition(position = 0)
    private String r_equipo1Nombre;
    @CsvBindByPosition(position = 1)
    private String r_equipo1Goles;
    @CsvBindByPosition(position = 2)
    private String r_equipo2Goles;
    @CsvBindByPosition(position = 3)
    private String r_equipo2Nombre;

    public String getR_equipo1Nombre() {
        return r_equipo1Nombre;
    }

    public String getR_equipo1Goles() {
        return r_equipo1Goles;
    }

    public String getR_equipo2Goles() {
        return r_equipo2Goles;
    }

    public String getR_equipo2Nombre() {
        return r_equipo2Nombre;
    }

    public void setR_equipo1Nombre(String r_equipo1Nombre) {
        this.r_equipo1Nombre = r_equipo1Nombre;
    }

    public void setR_equipo1Goles(String r_equipo1Goles) {
        this.r_equipo1Goles = r_equipo1Goles;
    }

    public void setR_equipo2Goles(String r_equipo2Goles) {
        this.r_equipo2Goles = r_equipo2Goles;
    }

    public void setR_equipo2Nombre(String r_equipo2Nombre) {
        this.r_equipo2Nombre = r_equipo2Nombre;
    }

   
}  
    