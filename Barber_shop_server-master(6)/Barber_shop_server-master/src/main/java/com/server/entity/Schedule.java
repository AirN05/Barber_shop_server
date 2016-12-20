package com.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="schedule")
public class Schedule {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id_schedule",nullable = false)
    private long id_schedule;

    @Column(name="id_emp",nullable = false)
    private long  id_emp;

    @Column(name="time", nullable = false)
    private Date time;

    @Column(name="id_res")
    private long id_res;

    @Column(name="reserve")
    private int reserve;

    public long getId_schedule() {
        return id_schedule;
    }

    public void setId_schedule(long id_schedule) {
        this.id_schedule = id_schedule;
    }

    public long getId_emp() {
        return id_emp;
    }

    public void setId_emp(long id_emp) {
        this.id_emp = id_emp;
    }

    public Date getDate() {
        return time;
    }

    public void setDate(Date date) {
        this.time = date;
    }

    public long getId_res() {
        return id_res;
    }

    public void setId_res(long id_res) {
        this.id_res = id_res;
    }

    public int getReserve() {
        return reserve;
    }

    public void setReserve(int reserve) {
        this.reserve = reserve;
    }
}
