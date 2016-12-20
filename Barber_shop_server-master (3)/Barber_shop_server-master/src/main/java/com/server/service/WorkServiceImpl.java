package com.server.service;


import com.server.entity.Work;
import com.server.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService{
    @Autowired
    WorkRepository shopRepository;

    public List<Work> gettAll() {
        return shopRepository.findAll();
    }

    public Work getByID(Long id) {
        return shopRepository.findOne(id);
    }

    public Work save(Work shop_item) {
        return shopRepository.saveAndFlush(shop_item);
    }

    public void remove(Long id) {
        shopRepository.delete(id);
    }

}
