package com.swiggyclone.repository;

import com.swiggyclone.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    public List<OrderItem> findByOrderId(Long orderId);
    public List<OrderItem> findByMenuItemId(Long menuItemId);
}
