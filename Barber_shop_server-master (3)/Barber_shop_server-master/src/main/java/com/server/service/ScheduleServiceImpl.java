package com.server.service;

import com.server.entity.Schedule;
import com.server.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    ScheduleRepository scheduleRepository;

    public List<Schedule> gettAll() {
        return scheduleRepository.findAll();
    }

    public Schedule getByID(Long id) {
        return scheduleRepository.findOne(id);
    }

    public Schedule save(Schedule schedule) {
        return scheduleRepository.saveAndFlush(schedule);
    }

    public void remove(Long id) {
        scheduleRepository.delete(id);
    }
}
