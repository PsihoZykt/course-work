package usualstudent.coursework.database.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

/**
 * Сущность БД, которая хранит информацию о зарегистрированных пользователях
 */
@Entity
public class Users implements UserDetails{
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
    private Date userBirthDate;
    private String userGender;
    /**
     * Электронная почта
     */
    @Column(unique = true)
    private String userEmail;
    private Boolean active = true;
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
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    /**
     * Является ли пользователь забаненным
     */
    private Boolean isBanned = false;
//    @Column(name = "active")
//    private Boolean active = true;

    public Users() {

    }

    public Date getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(Date userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    /**
     * Конструкторdsa, который используется при регистрации пользователя в системе
     *
     * @param userName     Имя пользователя
     * @param userEmail    Электронная почта
     * @param userPassword Пароль
     */
    public Users(String userName, String userEmail, Integer userPassword, String userBirthDate, String userGender)throws ParseException {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.registrationDate = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        Date date = format.parse(userBirthDate);
        this.userBirthDate = date ;
        this.userGender = userGender;


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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
       return userPassword.toString();
    }

    @Override
    public String getUsername() {
return getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
