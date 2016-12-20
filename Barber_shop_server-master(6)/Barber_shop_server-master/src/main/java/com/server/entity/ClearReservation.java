package com.server.entity;


public class ClearReservation {

    private long id_res;
    private Employee emp;
    private Price price;
    private String time;
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public long getId_res() {
        return id_res;
    }

    public void setId_res(long id_res) {
        this.id_res = id_res;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
