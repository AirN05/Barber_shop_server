package com.server.service;

import com.server.entity.Work;

import java.util.List;


public interface WorkService {

    List<Work> gettAll();
    Work getByID(Long id);
    Work save(Work home_image);
    void remove(Long id);
}
