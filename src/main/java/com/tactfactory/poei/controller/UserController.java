package com.tactfactory.poei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tactfactory.poei.entity.User;
import com.tactfactory.poei.repository.UserRepository;

@RestController
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping("user")
    public Iterable<User> getAll() {
        return this.repository.findAll();
    }
    
    @DeleteMapping("user/{id:^\\d+$}")
    public void delete(@PathVariable Long id) {
        this.repository.delete(id);
    }
}
