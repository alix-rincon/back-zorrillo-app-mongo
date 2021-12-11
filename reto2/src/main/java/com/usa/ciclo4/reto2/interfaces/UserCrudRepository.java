package com.usa.ciclo4.reto2.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

import com.usa.ciclo4.reto2.model.User;

public interface UserCrudRepository extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);

}
