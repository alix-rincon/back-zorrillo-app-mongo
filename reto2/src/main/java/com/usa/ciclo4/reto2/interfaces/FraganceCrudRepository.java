package com.usa.ciclo4.reto2.interfaces;

import com.usa.ciclo4.reto2.model.Fragance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FraganceCrudRepository extends MongoRepository<Fragance, String> {

}
