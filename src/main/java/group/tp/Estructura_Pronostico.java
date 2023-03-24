package group.tp;

/**
 *
 * @author GRUPO 13
 */
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import java.time.LocalDate;

public class Estructura_Pronostico {

    @CsvBindByPosition(position = 0)
    private String p_Filler;
    @CsvBindByPosition(position = 1)
    private Integer p_idRonda;
    @CsvBindByPosition(position = 2)
    private Integer p_idPronostico;
    @CsvBindByPosition(position = 3)
    private Integer p_idPartido;
    @CsvBindByPosition(position = 4)
    private Integer p_idEquipo1;
    @CsvBindByPosition(position = 5)
    private char p_gana1;
    @CsvBindByPosition(position = 6)
    private char p_empata;
    @CsvBindByPosition(position = 7)
    private char p_gana2;
    @CsvBindByPosition(position = 8)
    private Integer p_idEquipo2;

    // Getters

    public String getP_Filler() {
        return p_Filler;
    }

    public Integer getP_idRonda() {
        return p_idRonda;
    }

    public Integer getP_idPronostico() {
        return p_idPronostico;
    }

    public Integer getP_idPartido() {
        return p_idPartido;
    }

    public Integer getP_idEquipo1() {
        return p_idEquipo1;
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

    public Integer getP_idEquipo2() {
        return p_idEquipo2;
    }
    
// Setters

    public void setP_Filler(String p_Filler) {
        this.p_Filler = p_Filler;
    }

    public void setP_idRonda(Integer p_idRonda) {
        this.p_idRonda = p_idRonda;
    }

    public void setP_idPronostico(Integer p_idPronostico) {
        this.p_idPronostico = p_idPronostico;
    }

    public void setP_idPartido(Integer p_idPartido) {
        this.p_idPartido = p_idPartido;
    }

    public void setP_idEquipo1(Integer p_idEquipo1) {
        this.p_idEquipo1 = p_idEquipo1;
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

    public void setP_idEquipo2(Integer p_idEquipo2) {
        this.p_idEquipo2 = p_idEquipo2;
    }

    
}
