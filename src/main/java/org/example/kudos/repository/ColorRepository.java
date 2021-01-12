package org.example.kudos.repository;

import org.example.kudos.model.Color;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ColorRepository extends MongoRepository<Color, String> {
    public List<Color> findAll();
    public Optional<Color> findById(String id);
}
