package com.server.service;


import com.server.entity.Schedule;

import java.util.List;

public interface ScheduleService {

    List<Schedule> gettAll();
    Schedule getByID(Long id);
    Schedule save(Schedule schedule);
    void remove(Long id);
}
