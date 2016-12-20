package com.server.repository;

import com.server.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShopRepository extends JpaRepository<Shop,Long> {
}
