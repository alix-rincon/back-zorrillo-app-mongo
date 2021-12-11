package com.usa.ciclo4.reto2.repository;

import java.util.List;
import java.util.Optional;

import com.usa.ciclo4.reto2.interfaces.FraganceCrudRepository;
import com.usa.ciclo4.reto2.model.Fragance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FraganceRepository {

    @Autowired
    private FraganceCrudRepository fraganceCrudRepository;

    public Optional<Fragance> getFragance(String reference) {
        return fraganceCrudRepository.findById(reference);
    }

    public List<Fragance> getAllFragance() {
        return fraganceCrudRepository.findAll();
    }

    public Fragance create(Fragance fragance) {
        return fraganceCrudRepository.save(fragance);
    }

    public void update(Fragance fragance){
        fraganceCrudRepository.save(fragance);
    }

    public void delete (Fragance fragance){
        fraganceCrudRepository.delete(fragance);
    }
}
