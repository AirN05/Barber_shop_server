package com.server.service;

import com.server.entity.Home;
import java.util.List;

public interface HomeService {
    List<Home> gettAll();
    Home getByID(Long id);
    Home save(Home home_image);
    void remove(Long id);
}
