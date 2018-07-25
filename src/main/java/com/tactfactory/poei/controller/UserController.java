package com.tactfactory.poei.controller;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("user")
    public Map<String, String> create(@Valid @RequestBody User user) {
        this.repository.save(user);
        
        return Collections.singletonMap("message", "success");
    }

//    @PostMapping("user")
//    public Map<String, String> create(@RequestBody User user, HttpServletResponse response) {
//        
//        if (user.getFirstname() == null) {
//            response.setStatus(400);
//            return Collections.singletonMap("message", "error, firstname required");
//        }
//        
//        this.repository.save(user);
//        
//        return Collections.singletonMap("message", "success");
//    }
}
