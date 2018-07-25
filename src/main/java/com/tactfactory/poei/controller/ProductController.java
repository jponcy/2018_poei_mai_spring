package com.tactfactory.poei.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tactfactory.poei.entity.Product;
import com.tactfactory.poei.repository.ProductRepository;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository repository;

    // @RequestMapping(name = "product", method = RequestMethod.GET)
    @GetMapping("product")
    public List<Product> getAll() {
        return this.repository.findAll();
    }

    @PostMapping("product")
    public Map<String, String> create(@RequestParam String name, @RequestParam Float price,
            @RequestParam(required = false) Integer stock) {
        Product entity = new Product();

        entity.setName(name);
        entity.setPrice(price);

        if (stock != null) {
            entity.setStock(stock);
        }

        this.repository.save(entity);

        return Collections.singletonMap("message", "Congratulation, id = " + entity.getId());
    }
}
