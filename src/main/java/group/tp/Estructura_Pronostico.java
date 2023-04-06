package group.tp;

/**
 *
 * @author GRUPO 13
 */
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import java.time.LocalDate;

public class Estructura_Pronostico {

    //@CsvBindByPosition(position = 0)
    //private String p_filler;
    @CsvBindByPosition(position = 0)
    private String p_participanteNombre;
    @CsvBindByPosition(position = 1)
    private String p_idPartido;
    @CsvBindByPosition(position = 2)
    private String p_Equipo1;
    @CsvBindByPosition(position = 3)
    private char p_gana1;
    @CsvBindByPosition(position = 4)
    private char p_empata;
    @CsvBindByPosition(position = 5)
    private char p_gana2;
    @CsvBindByPosition(position = 6)
    private String p_Equipo2;

    public String getP_participanteNombre() {
        return p_participanteNombre;
    }

    public String getP_idPartido() {
        return p_idPartido;
    }
    

    public String getP_Equipo1() {
        return p_Equipo1;
    }

    public char getP_gana1() {
        return p_gana1;
    }

    public char getP_empata() {
        return p_empata;
    }

    public char getP_gana2() {
        return p_gana2;
    }

    public String getP_Equipo2() {
        return p_Equipo2;
    }

    public void setP_participanteNombre(String p_participanteNombre) {
        this.p_participanteNombre = p_participanteNombre;
    }

    public void setP_idPartido(String p_idPartido) {
        this.p_idPartido = p_idPartido;
    }

 
    public void setP_Equipo1(String p_Equipo1) {
        this.p_Equipo1 = p_Equipo1;
    }

    public void setP_gana1(char p_gana1) {
        this.p_gana1 = p_gana1;
    }

    public void setP_empata(char p_empata) {
        this.p_empata = p_empata;
    }

    public void setP_gana2(char p_gana2) {
        this.p_gana2 = p_gana2;
    }

    public void setP_Equipo2(String p_Equipo2) {
        this.p_Equipo2 = p_Equipo2;
    }

    
    
}

