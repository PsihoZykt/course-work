package usualstudent.coursework.controllers.entity;

import javax.persistence.*;

/**
 * Сущность БД , которая хранит рейтинговую таблицу
 */
@Entity
@Table(name = "rating")
public class Rating {
    /**
     * Primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "user_id", unique = true)
    private Users user;

    public Rating() {

    }

    public Rating(Integer rating, Users user) {
        this.rating = rating;
        this.user = user;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}

