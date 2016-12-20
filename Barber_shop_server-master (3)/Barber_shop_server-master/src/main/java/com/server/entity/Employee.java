package com.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long id_emp;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="image",nullable = false)
    private String image;

    @Column(name="city",nullable = false)
    private String city;

    @Column(name="describe")
    private String describe;

    public long getId_emp() {
        return id_emp;
    }

    public void setId_emp(long id_emp) {
        this.id_emp = id_emp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
