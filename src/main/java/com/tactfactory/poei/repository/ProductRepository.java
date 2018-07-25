package com.tactfactory.poei.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tactfactory.poei.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
    @Override
    List<Product> findAll();

    Optional<Product> findOneById(Long id);

    Product findByNameIgnoreCase(String tio);
}
