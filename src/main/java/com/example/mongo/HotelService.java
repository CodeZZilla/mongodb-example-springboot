package com.example.mongo;

import com.example.mongo.models.Hotel;
import com.example.mongo.repo.HotelRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepo repo;

    public HotelService(HotelRepo repo) {
        this.repo = repo;
    }

    public List<Hotel> findAll() {
        return repo.findAll();
    }

    public void save(Hotel hotel) {
        repo.save(hotel);
    }

    public void deleteById(String id) {
        repo.deleteById(id);
    }

    public Optional<Hotel> findById(String id) {
        return repo.findById(id);
    }
}
