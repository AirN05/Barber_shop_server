package com.server.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="pricelist")
public class Price {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id_price",nullable = false)
    private long id_price;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="price",nullable = false)
    private String price;

    @Column(name="options")
    private String options;


    public long getId_price() {
        return id_price;
    }

    public void setId_price(long id_price) {
        this.id_price = id_price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

}
