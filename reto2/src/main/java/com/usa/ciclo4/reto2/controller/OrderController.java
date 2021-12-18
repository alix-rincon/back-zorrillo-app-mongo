package com.usa.ciclo4.reto2.controller;

import java.util.List;
import java.util.Optional;

import com.usa.ciclo4.reto2.model.Order;
import com.usa.ciclo4.reto2.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/all")
    public List<Order> getAll(String param) {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderId(@PathVariable("id") int orderId) {
        return orderService.getOrder(orderId);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Order order) {
        orderService.create(order);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Order order) {
        orderService.update(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return orderService.delete(id);
    }

    @GetMapping("/zona/{zona}")
    public List<Order> findByZone(@PathVariable("zona") String zona) {
        return orderService.findByZone(zona);
    }

    @GetMapping("/salesman/{id}")
    public List<Order> ordersSalesManByID(@PathVariable("id") int id) {
        return orderService.ordersSalesManByID(id);
    }

    @GetMapping("/date/{date}/{id}")
    public List<Order> ordersSalesManByDate(@PathVariable("date") String date, @PathVariable("id") int id) {
        return orderService.ordersSalesManByDate(date, id);
    }

    @GetMapping("/state/{state}/{id}")
    public List<Order> ordersSalesManByState(@PathVariable("state") String date, @PathVariable("id") int id) {
        return orderService.ordersSalesManByState(date, id);
    }

}
