package com.server.service;

import com.server.entity.Remind;
import com.server.repository.RemindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReminderServiceImpl implements ReminderService {

 @Autowired
    RemindRepository remindRepository;
    public List<Remind> gettAll() {
        return remindRepository.findAll();
    }

    public Remind getByID(Long id) {
        return remindRepository.findOne(id);
    }

    public Remind save(Remind remind) {
        return remindRepository.saveAndFlush(remind);
    }

    public void remove(Long id) {
        remindRepository.delete(id);
    }
}
