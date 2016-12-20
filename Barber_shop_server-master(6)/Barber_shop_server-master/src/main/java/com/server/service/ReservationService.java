package com.server.service;


import com.server.entity.Reservation;
import java.util.List;

public interface ReservationService {
    List<Reservation> gettAll();
    Reservation getByID(Long id);
    Reservation save(Reservation emp);
    void remove(Long id);

}
