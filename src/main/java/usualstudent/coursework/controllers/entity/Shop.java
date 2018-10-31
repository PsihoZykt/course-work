package usualstudent.coursework.controllers.entity;

import javax.persistence.*;

/**
 * Сущность БД, Которая хранит информацию о магазине
 */

@Entity
public class Shop {
    /**
     * Primary key
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Имя товара
     */


    @Column(unique = true)
    private String productName;
    /**
     * Его цена
     */

    private Integer productPrice;
    /**
     * Сколько единиц товара осталось на "складе"
     */

    private Integer amount;

    public Shop() {

    }

    /**
     * @param productName  Имя товара
     * @param productPrice Цена товара
     * @param amount       Количество единиц товара на складе
     */
    public Shop(String productName, Integer productPrice, Integer amount) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.amount = amount;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
