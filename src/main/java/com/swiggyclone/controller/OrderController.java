package com.swiggyclone.controller;

import com.swiggyclone.entity.Order;
import com.swiggyclone.event.OrderEvent;
import com.swiggyclone.repository.OrderRepository;
import com.swiggyclone.service.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    private final KafkaProducer producer;


    @GetMapping
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderRepository.findById(id).get();
    }

    @PostMapping
    public void addOrder(@RequestBody Order order) {
        orderRepository.save(order);
    }

    @PutMapping("/{id}")
    public void updateOrder(@RequestBody Order order, @PathVariable Long id) {
        Order oldOrder = getOrder(id);
        oldOrder.setStatus(order.getStatus());
        oldOrder.setUser(order.getUser());
        oldOrder.setRestaurant(order.getRestaurant());
        orderRepository.save(oldOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }

    @GetMapping("/orderByRestaurant/{id}")
    public List<Order> getOrdersByRestaurant(@PathVariable Long restaurantId) {
        return orderRepository.findOrderByRestaurantId(restaurantId);
    }

    @GetMapping("/orderByUserId/{id}")
    public List<Order> getOrdersByUserId(@PathVariable Long userId) {
        return orderRepository.findOrderByUserId(userId);
    }

    @PostMapping("/status")
    public String sendOrder(@RequestBody OrderEvent order) {
        producer.sendOrderStatus(order);
        return "Message sent to Kafka!";
    }

}
