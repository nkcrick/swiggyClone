package com.swiggyclone.controller;

import com.swiggyclone.entity.MenuItem;
import com.swiggyclone.repository.MenuItemRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menuItems")
public class MenuItemController {

    @Autowired
    MenuItemRepository repository;

    @GetMapping
    public List<MenuItem> getMenuItems() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public MenuItem getMenuItem(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PutMapping
    public MenuItem saveMenuItem(@RequestBody MenuItem menuItem) {
        return repository.save(menuItem);
    }

    @DeleteMapping
    public void deleteMenuItem(Long id) {
        repository.deleteById(id);
    }

    @PostMapping("/{id}")
    public MenuItem updateMenuItem(@PathVariable Long id ,@RequestBody MenuItem menuItem) {
        MenuItem oldMenuItem = repository.findById(id).get();
        oldMenuItem.setName(menuItem.getName());
        oldMenuItem.setDescription(menuItem.getDescription());
        oldMenuItem.setPrice(menuItem.getPrice());
        oldMenuItem.setAvailable(menuItem.getAvailable());
        oldMenuItem.setImage_url(menuItem.getImage_url());
        return repository.save(oldMenuItem);
    }
}
