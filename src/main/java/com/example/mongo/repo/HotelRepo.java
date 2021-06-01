package com.example.mongo.repo;

import com.example.mongo.models.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface HotelRepo extends MongoRepository<Hotel, String> {
}
