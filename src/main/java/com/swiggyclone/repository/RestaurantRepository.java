package com.swiggyclone.repository;

import com.swiggyclone.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    public Restaurant findByName(String name);
}
