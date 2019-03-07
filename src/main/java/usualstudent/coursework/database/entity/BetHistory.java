package usualstudent.coursework.database.entity;

import javax.persistence.*;

/**
 * Cущность БД, которая хранит историю всех ставок
 */
@Entity
public class BetHistory {
    /**
     * Primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Поле отвечающее за то, была ли данная ставка верной
     * если true - пользователь сделал ставку на выигравшего покемона
     */

    private Boolean isSuccess;
    /**
     * Связь истории ставок с конкретной ставкой
     * foreign key
     */
    @ManyToOne
    @JoinColumn(name = "bet_id")
    private Bet bet;

    /**
     * Не заставляем спринг грустить
     */
    public BetHistory() {

    }

    /**
     * @param isSuccess была ли ставка успешной
     * @param bet       Количество денег, которое поставил пользователь
     */
    public BetHistory(Boolean isSuccess, Bet bet) {
        this.isSuccess = isSuccess;
        this.bet = bet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }
}
