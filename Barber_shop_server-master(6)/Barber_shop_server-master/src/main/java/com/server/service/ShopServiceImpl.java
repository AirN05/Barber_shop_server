package com.server.service;


import com.server.entity.Shop;
import com.server.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ShopServiceImpl implements ShopService{

    @Autowired
    ShopRepository shopRepository;

    public List<Shop> gettAll() {
        return shopRepository.findAll();
    }

    public Shop getByID(Long id) {
        return shopRepository.findOne(id);
    }

    public Shop save(Shop shop_item) {
        return shopRepository.saveAndFlush(shop_item);
    }

    public void remove(Long id) {
        shopRepository.delete(id);
    }
}
