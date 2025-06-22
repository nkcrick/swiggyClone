package com.swiggyclone.repository;

import com.swiggyclone.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    public List<Order> findOrderByRestaurantId(Long restaurantId);

    public List<Order> findOrderByUserId(Long userId);
}
