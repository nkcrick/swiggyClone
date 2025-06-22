package com.swiggyclone.repository;

import com.swiggyclone.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    public List<CartItem> findByUserId(Long userId);
}
