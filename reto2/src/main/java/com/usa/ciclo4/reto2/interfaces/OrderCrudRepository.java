package com.usa.ciclo4.reto2.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

import com.usa.ciclo4.reto2.model.Order;

public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    
    //Retorna las ordenes de pedido que coincidan con la zona recibida.
    @Query("{'salesMan.zone' : ?0 }")
    List<Order> findByZone(final String zone);

    //Filtra por estado de la orden
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);

    Optional<Order> findTopByOrderByIdDesc();
    
}
