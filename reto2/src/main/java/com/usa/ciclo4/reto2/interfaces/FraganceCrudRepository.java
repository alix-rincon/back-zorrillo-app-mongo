package com.usa.ciclo4.reto2.interfaces;
import java.util.List;
import com.usa.ciclo4.reto2.model.Fragance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface FraganceCrudRepository extends MongoRepository<Fragance, String> {

    public List<Fragance> findByPriceLessThanEqual(double precio);


    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Fragance> findByDescriptionLike(String description);
}
