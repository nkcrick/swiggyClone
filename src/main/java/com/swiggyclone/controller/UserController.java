package com.swiggyclone.controller;

import com.swiggyclone.entity.User;
import com.swiggyclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/register")
    public User registerNewUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("/me")
    public User getOwnProfile(@RequestParam Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User userToUpdate = userRepository.findById(id).orElse(null);
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setRole(user.getRole());
        return userRepository.save(userToUpdate);
    }

    @PostMapping("/me")
    public User updateOwnProfile(@RequestParam Long id, @RequestBody User user) {
        User userToUpdate = userRepository.findById(id).orElse(null);
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setRole(user.getRole());
        return userRepository.save(userToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

}
