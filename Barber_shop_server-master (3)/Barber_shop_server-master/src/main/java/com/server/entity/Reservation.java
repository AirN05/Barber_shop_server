package com.server.entity;


import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="reservation")
public class Reservation {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id_res",nullable = false)
    private long id_res;

    @Column(name="id_emp",nullable = false)
    private long  id_emp;

    @Column(name="id_price",nullable = false)
    private long id_price;

    @Column(name="id_user", nullable = false)
    private long id_user;

    @Column(name="time", nullable = false)
    private Date time;

    public long getId_res() {
        return id_res;
    }

    public void setId_res(long id_res) {
        this.id_res = id_res;
    }

    public long getId_emp() {
        return id_emp;
    }

    public void setId_emp(long id_emp) {
        this.id_emp = id_emp;
    }

    public long getId_price() {
        return id_price;
    }

    public void setId_price(long id_price) {
        this.id_price = id_price;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
