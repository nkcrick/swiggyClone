package com.swiggyclone.controller;

import com.swiggyclone.entity.Restaurant;
import com.swiggyclone.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@CrossOrigin
public class RestaurantController {

    @Autowired
    RestaurantRepository restaurantRepository;

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable Long id) {
        return restaurantRepository.findById(id).get();
    }

    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id,@RequestBody Restaurant restaurant) {
        Restaurant restaurantToUpdate = restaurantRepository.findById(id).get();
        restaurantToUpdate.setName(restaurant.getName());
        restaurantToUpdate.setAddress(restaurant.getAddress());
        restaurantToUpdate.setPhone(restaurant.getPhone());
        restaurantToUpdate.setOwner(restaurant.getOwner());
        return restaurantRepository.save(restaurant);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantRepository.deleteById(id);
    }

    @GetMapping("/findByName")
    public Restaurant getRestaurantByName(@RequestParam(name = "name") String name) {
        return restaurantRepository.findByName(name);
    }
}
