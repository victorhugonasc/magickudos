package org.example.kudos.repository;

import org.example.kudos.model.Kudo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface KudoRepository extends MongoRepository<Kudo, String> {
    public List<Kudo> findAll();
    public Optional<Kudo> findById(String id);
}
