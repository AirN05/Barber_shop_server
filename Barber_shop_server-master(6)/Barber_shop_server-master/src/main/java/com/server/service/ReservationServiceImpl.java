package com.server.service;


import com.server.entity.Reservation;
import com.server.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    ReservationRepository resRepository;
    public List<Reservation> gettAll() {
        return resRepository.findAll();
    }

    public Reservation getByID(Long id) {
        return resRepository.findOne(id);
    }

    public Reservation save(Reservation res) {
        return resRepository.saveAndFlush(res);
    }

    public void remove(Long id) {
        resRepository.delete(id);
    }
}
