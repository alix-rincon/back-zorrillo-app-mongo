package com.usa.ciclo4.reto2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.usa.ciclo4.reto2.service.UserService;
import com.usa.ciclo4.reto2.model.User;
import java.util.List;
import java.util.Optional;

/**
 * @author: Alix Rincón
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    /**
     * UserService
     */
    @Autowired
    private UserService userService;

    /**
     * 
     * @return List
     */
    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    /**
     * 
     * @param id
     * @return Optional
     */
    @GetMapping("/{id}")
    public Optional<User> getUserId(@PathVariable("id") int userId) {
        return userService.getUser(userId);
    }

    /**
     * 
     * @param email
     * @return boolean
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExist(@PathVariable("email") String email) {
        return userService.emailExist(email);
    }

    /**
     * 
     * @param email
     * @param password
     * @return User
     */
    @GetMapping("/{email}/{password}")
    public User authenticaUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }

    /**
     * 
     * @param user
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody User userObject) {
        userService.create(userObject);
    }

    /**
     * 
     * @param user
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody User userObject) {
        userService.update(userObject);
    }

    /**
     * 
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int userId) {
        return userService.delete(userId);
    }

    @GetMapping("/birthday/{month}")
    public List<User> birthtDayList(@PathVariable("month") String monthBirthtDay) {
        return userService.birthtDayList(monthBirthtDay);
    }
}
