package com.server.service;

import com.server.entity.Price;

import java.util.List;

public interface PriceService {
    List<Price> gettAll();
    Price getByID(Long id);
    Price save(Price home_image);
    void remove(Long id);
}
