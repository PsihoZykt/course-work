package usualstudent.coursework.database.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
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
    private String username;
    /**
     * Дата регистрации
     */
    private Date registrationDate;
    private String birthDate;
    private String gender;

    /**
     * Электронная почта
     */
    @Column(unique = true)
    private String email;
    private Boolean active = true;
    /**
     * Пароль
     */
    private String password; // TODO: Что нибудь сделать с шифрованием пароля
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
    private Integer rating = 0;
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
    public boolean isAdmin() {
        return roles.contains(Role.ADMIN);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getMoney() {
        return Money;
    }

    public void setMoney(Integer money) {
        Money = money;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Boolean getBanned() {
        return isBanned;
    }

    public void setBanned(Boolean banned) {
        isBanned = banned;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
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

    @Override
    public String getUsername() {
        return username;
    }



    @Override
    public String getPassword() {
        return password;
    }


}