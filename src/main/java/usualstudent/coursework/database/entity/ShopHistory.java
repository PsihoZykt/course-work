package usualstudent.coursework.database.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by PsihoZ on 22.10.2018.
 */

@Entity
public class ShopHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    private Date date;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Shop shop;


    public ShopHistory() {

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
