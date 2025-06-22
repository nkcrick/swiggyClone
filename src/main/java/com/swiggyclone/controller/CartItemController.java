package com.swiggyclone.controller;

import com.swiggyclone.entity.CartItem;
import com.swiggyclone.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cart/")
public class CartItemController {
    @Autowired
    CartItemRepository cartItemRepository;

    @GetMapping
    public List<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }

    @PostMapping
    public CartItem addCartItems(@RequestBody CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @PutMapping("/{cartItemId}")
    public CartItem updateCartItemsQuantity(@PathVariable Long cartItemId, @RequestParam String quantity) {
        CartItem cartItem = cartItemRepository.findById(cartItemId).get();
        cartItem.setQuantity(Integer.parseInt(quantity));
        return cartItemRepository.save(cartItem);
    }

    @DeleteMapping("/{cartItemId}")
    public CartItem deleteCartItem(@PathVariable Long cartItemId) {
        CartItem cartItem = cartItemRepository.findById(cartItemId).get();
        cartItemRepository.delete(cartItem);
        return cartItem;
    }

    @DeleteMapping("/clear")
    public List<CartItem> deleteAllCartItem(@RequestParam Long cartItemId) {
        List<CartItem> cartItems = cartItemRepository.findByUserId(cartItemId);
        cartItemRepository.deleteAll(cartItems);
        return cartItemRepository.findByUserId(cartItemId);
    }


}
