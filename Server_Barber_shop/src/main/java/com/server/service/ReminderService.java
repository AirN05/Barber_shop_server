package com.server.service;

import com.server.entity.Remind;

import java.util.List;

public interface ReminderService {
    List<Remind> gettAll();
    Remind getByID(Long id);
    Remind save(Remind remind);
    void remove(Long id);
}
