package usualstudent.coursework.controllers.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Сущность БД, которая хранит информацию о зарегистрированных пользователях
 */
@Entity
public class Users {
    /**
     * Primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя пользователя
     */
    @Column(unique = true)
    private String userName;
    /**
     * Дата регистрации
     */
    private Date registrationDate;
    /**
     * Электронная почта
     */
    @Column(unique = true)
    private String userEmail;
    /**
     * Пароль
     */
    private Integer userPassword; // TODO: Что нибудь сделать с шифрованием пароля
    /**
     * Количество сделанных ставок
     */
    private Integer betAmount = 0;
    /**
     * Процент выигранных ставок
     */
    private Integer betWinProcent = 0;
    /**
     * Любимый покемон
     */
    private String FavouritePokemon = "";
    /**
     * Количество условного рейтинга пользователя
     */
    private Integer Rating = 0;
    /**
     * Количество валюты , которые имеются на аккаунте у пользователя
     */
    private Integer Money = 100;
    private String passwordConfirm;
    /**
     * Является ли пользователь забаненным
     */
    private Boolean isBanned = false;

    public Users() {

    }

    /**
     * Конструктор, который используется при регистрации пользователя в системе
     *
     * @param userName     Имя пользователя
     * @param userEmail    Электронная почта
     * @param userPassword Пароль
     */
    public Users(String userName, String userEmail, Integer userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.registrationDate = new Date();
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(Integer userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(Integer betAmount) {
        this.betAmount = betAmount;
    }

    public Integer getBetWinProcent() {
        return betWinProcent;
    }

    public void setBetWinProcent(Integer betWinProcent) {
        this.betWinProcent = betWinProcent;
    }

    public String getFavouritePokemon() {
        return FavouritePokemon;
    }

    public void setFavouritePokemon(String favouritePokemon) {
        FavouritePokemon = favouritePokemon;
    }

    public Integer getRating() {
        return Rating;
    }

    public void setRating(Integer rating) {
        Rating = rating;
    }

    public Integer getMoney() {
        return Money;
    }

    public void setMoney(Integer money) {
        Money = money;
    }

    public Boolean getBanned() {
        return isBanned;
    }

    public void setBanned(Boolean banned) {
        isBanned = banned;
    }

}
