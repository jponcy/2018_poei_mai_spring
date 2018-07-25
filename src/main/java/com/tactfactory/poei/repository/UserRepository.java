package com.tactfactory.poei.repository;

import org.springframework.data.repository.CrudRepository;

import com.tactfactory.poei.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
