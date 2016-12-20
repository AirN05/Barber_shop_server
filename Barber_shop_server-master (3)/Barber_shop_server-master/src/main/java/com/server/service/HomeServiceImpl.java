package com.server.service;

import com.server.entity.Home;
import com.server.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    HomeRepository homeRepository;
    public List<Home> gettAll() {
        return homeRepository.findAll();
    }

    public Home getByID(Long id) {
        return homeRepository.findOne(id);
    }

    public Home save(Home home_item) {
        return homeRepository.saveAndFlush(home_item);
    }

    public void remove(Long id) {
        homeRepository.delete(id);
    }
}
