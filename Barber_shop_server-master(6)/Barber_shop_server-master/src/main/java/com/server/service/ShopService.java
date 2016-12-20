package com.server.service;


import com.server.entity.Shop;

import java.util.List;

public interface ShopService {

    List<Shop> gettAll();
    Shop getByID(Long id);
    Shop save(Shop shop_item);
    void remove(Long id);
}
