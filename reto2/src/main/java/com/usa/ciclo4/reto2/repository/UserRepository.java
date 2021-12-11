package com.usa.ciclo4.reto2.repository;

import java.util.List;
import java.util.Optional;

import com.usa.ciclo4.reto2.interfaces.UserCrudRepository;
import com.usa.ciclo4.reto2.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }

    public List<User> getAllUser(){
        return userCrudRepository.findAll();
    }

    public boolean emailExist(String email){
        Optional<User> user =  userCrudRepository.findByEmail(email);
        return !user.isEmpty();
    }

    public Optional<User> authenticateUser(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    public User create(User user){
        return userCrudRepository.save(user);
    }

    public void update(User user){
        userCrudRepository.save(user);
    }

    public void delete(User user){
        userCrudRepository.delete(user);
    }
    
}
