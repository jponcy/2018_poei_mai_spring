package com.tactfactory.poei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products") 
public class Product {
    @Id // Primary key.
    @GeneratedValue // "AUTO_INCREMENT / serial ..."
    private Long id;
    
    @Column(length = 50, unique = true, nullable = false)
    private String name;
    
    private float price;

    /**
     * Si = null => disponible prochainement.
     */
    @Column(nullable = true)
    private Integer stock;

    public Product() {
        this(null, 0f, null);
    }
    
    public Product(String name, float price, Integer stock) {
        this.setName(name);
        this.setPrice(price);
        this.setStock(stock);
    }

    /**
     * @return the id
     */
    public final Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public final void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public final void setName(final String name) {
        this.name = name == null ? null : name.trim().toLowerCase();
        
//        if (name == null) {
//            this.name = null;
//        } else {
//            this.name = name.trim().toLowerCase();
//        }
    }

    /**
     * @return the price
     */
    public final float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public final void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the stock
     */
    public final Integer getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public final void setStock(Integer stock) {
        this.stock = stock;
    }
}
