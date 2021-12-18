package com.usa.ciclo4.reto2.service;

import java.util.List;
import java.util.Optional;

import com.usa.ciclo4.reto2.model.Fragance;
import com.usa.ciclo4.reto2.repository.FraganceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FranganceService {

    @Autowired
    private FraganceRepository fraganceRepository;

    public Optional<Fragance> getFragance(String reference) {
        return fraganceRepository.getFragance(reference);
    }

    public List<Fragance> getAllFragance() {
        return fraganceRepository.getAllFragance();
    }

    public Fragance create(Fragance fragance) {
        if (fragance.getReference() == null) {
            return fragance;
        } else {
            Optional<Fragance> fraganceId = fraganceRepository.getFragance(fragance.getReference());
            if (fraganceId.isEmpty()) {
                
                return fraganceRepository.create(fragance);

            } else {
                return fragance;
            }
        }

    }

    public Fragance update(Fragance fragance) {
        if (fragance.getReference() != null) {
            Optional<Fragance> fraganceRecord = fraganceRepository.getFragance(fragance.getReference());
            if (!fraganceRecord.isEmpty()) {
                if (fragance.getBrand() != null) {
                    fraganceRecord.get().setBrand(fragance.getBrand());
                }
                if (fragance.getCategory() != null) {
                    fraganceRecord.get().setCategory(fragance.getCategory());
                }
                if (fragance.getPresentation() != null) {
                    fraganceRecord.get().setPresentation(fragance.getPresentation());
                }
                if (fragance.getDescription() != null) {
                    fraganceRecord.get().setDescription(fragance.getDescription());
                }
                if (fragance.getPrice() != 0) {
                    fraganceRecord.get().setPrice(fragance.getPrice());
                }
                if (fragance.getQuantity() != 0) {
                    fraganceRecord.get().setQuantity(fragance.getQuantity());
                }
                if (fragance.getPhotography() != null) {
                    fraganceRecord.get().setPhotography(fragance.getPhotography());
                }
                
                fraganceRecord.get().setAvailability(fragance.isAvailability());
                

                fraganceRepository.update(fraganceRecord.get());
                return fraganceRecord.get();
            } else {
                return fragance;
            }
        } else {
            return fragance;
        }
    }

    public boolean delete(String fraganceId) {
        Boolean aBoolean = getFragance(fraganceId).map(fragance -> {
            fraganceRepository.delete(fragance);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    //Reto 5
    public List<Fragance> fraganceByPrice(double price) {
        return fraganceRepository.fraganceByPrice(price);
    }

    //Reto 5
    public List<Fragance> findByDescriptionLike(String description) {
        return fraganceRepository.findByDescriptionLike(description);
    }
}
