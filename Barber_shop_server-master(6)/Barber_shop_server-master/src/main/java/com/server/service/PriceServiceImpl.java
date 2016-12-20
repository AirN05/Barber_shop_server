package com.server.service;


import com.server.entity.Price;
import com.server.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService{

    @Autowired
    PriceRepository priceRepository;
    public List<Price> gettAll() {
        return priceRepository.findAll();
    }

    public Price getByID(Long id) {
        return priceRepository.findOne(id);
    }

    public Price save(Price price_item) {
        return priceRepository.saveAndFlush(price_item);
    }

    public void remove(Long id) {
        priceRepository.delete(id);
    }
}
