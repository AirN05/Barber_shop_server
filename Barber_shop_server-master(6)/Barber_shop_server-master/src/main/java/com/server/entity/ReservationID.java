package com.server.entity;


public class ReservationID {

    private User user;
    private Long id;

    public ReservationID(User user, Long id){
        this.id=id;
        this.user=user;
    }

    public ReservationID(){

    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
