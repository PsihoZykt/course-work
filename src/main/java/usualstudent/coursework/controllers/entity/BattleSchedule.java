package usualstudent.coursework.controllers.entity;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Сущность базы данных, отвечающее за хранение конкретной битвы покемонов
 */
@Entity
@Table(name = "battle")
public class BattleSchedule {
    /**
     * Primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * В битве учавствуют два покемона
     * pokemonName1 - имя первого покемона
     * pokeminName2 - Имя второго покемона
     */
    private String pokemonName1;
    private String pokemonName2;
    /**
     * Битвы происходят по расписанию
     * date - дата битвы покемонов в формате dd-M-yyyy hh:mm:ss
     */
    private Date date;

    /**
     * Чтобы спринг был счастлив создаем пустой конструктор
     */
    public BattleSchedule() {

    }

    /**
     * Конструктор создающий обьект битвы
     *
     * @param name1 Имя первого покемона
     * @param name2 Имя второго покемона
     * @param date  Дата битвы. Шаблон даты dd-M-yyyy hh:mm:ss
     * @throws ParseException при несоблюдении шаблона даты метод выбрасывает исключение
     */
    public BattleSchedule(String name1, String name2, String date) throws ParseException {
        this.pokemonName1 = name1;
        this.pokemonName2 = name2;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        this.date = sdf.parse(date);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPokemonName1() {
        return pokemonName1;
    }

    public void setPokemonName1(String pokemonName1) {
        this.pokemonName1 = pokemonName1;
    }

    public String getPokemonName2() {
        return pokemonName2;
    }

    public void setPokemonName2(String pokemonName2) {
        this.pokemonName2 = pokemonName2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
