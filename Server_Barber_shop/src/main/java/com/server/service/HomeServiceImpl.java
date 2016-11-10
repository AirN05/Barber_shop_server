package com.server.service;

import com.server.entity.Home;
import com.server.entity.Remind;
import com.server.repository.HomeRepository;
import com.server.repository.RemindRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 1 on 10.11.2016.
 */
public class HomeServiceImpl implements HomeService {

    @Autowired
    HomeRepository homeRepository;
    public List<Home> gettAll() {
        return homeRepository.findAll();
    }

    public Home getByID(Long id) {
        return homeRepository.findOne(id);
    }

    public Home save(Home home_image) {
        return homeRepository.saveAndFlush(home_image);
    }

    public void remove(Long id) {
        homeRepository.delete(id);
    }
}
