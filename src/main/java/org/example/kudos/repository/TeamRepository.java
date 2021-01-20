package org.example.kudos.repository;

import org.example.kudos.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TeamRepository extends MongoRepository<Team, String> {
    public List<Team> findAll();
}
