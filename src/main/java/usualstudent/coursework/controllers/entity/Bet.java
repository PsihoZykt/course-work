package usualstudent.coursework.controllers.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Сущность базы данных отвечающая за хранение ставки
 */
@Entity
public class Bet {
    /**
     * Primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Связь ставки и пользователя, который эту ставку сделал
     * Foreign Key
     */
    @ManyToOne
    private Users user;
    /**
     * Покемон, на которого была сделана ставка
     */

    private String pokemonName;
    /**
     * Коэффициент , на который умножится выигрыш в случае победы
     */

    private Integer coef;
    /**
     * Количество денег, который поставил пользователь
     */

    private Integer bet;
    /**
     * Связь ставки с конкретной битвой, на которую эта ставка сделана
     * foreign key
     */
    private Date betDate;

    @ManyToOne
    private BattleSchedule bs;

    /**
     * Не забываем осчастливить спринг пустым конструктором
     */
    public Bet() {

    }

    /**
     * @param user        Пользователь, сделавший ставку
     * @param pokemonName Имя покемона, на которого была сделана ставка
     * @param coef        Коэффицент, на который умножится выигрыш в случае если пользователь сделал верную ставку
     * @param bet         Количество денег, которое поставил пользователь
     * @param bs          Битва, на которую сделал ставку пользователь
     */
    public Bet(Users user, String pokemonName, Integer coef, Integer bet, BattleSchedule bs) {
        this.user = user;
        this.pokemonName = pokemonName;
        this.coef = coef;
        this.bet = bet;
        this.bs = bs;
        this.betDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public Integer getCoef() {
        return coef;
    }

    public void setCoef(Integer coef) {
        this.coef = coef;
    }

    public Integer getBet() {
        return bet;
    }

    public void setBet(Integer bet) {
        this.bet = bet;
    }

    public BattleSchedule getBs() {
        return bs;
    }

    public void setBs(BattleSchedule bs) {
        this.bs = bs;
    }

    public Date getBetDate() {
        return betDate;
    }

    public void setBetDate(Date betDate) {
        this.betDate = betDate;
    }
}
