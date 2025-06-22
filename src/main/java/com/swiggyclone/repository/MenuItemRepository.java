package com.swiggyclone.repository;

import com.swiggyclone.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    public MenuItem findByName(String name);
}
