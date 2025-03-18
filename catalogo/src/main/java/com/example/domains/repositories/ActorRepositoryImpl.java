package com.example.domains.repositories;

import java.security.Timestamp;
import java.util.List;

import com.example.domains.contracts.repositories.ActorRepository;
import com.example.domains.entities.Actor;

public class ActorRepositoryImpl {
    public ActorRepositoryImpl(ActorRepository actorRepository) {
        //TODO Auto-generated constructor stub
    }

    public List<Actor> findByLastUpdateGreaterThanEqualOrderByLastUpdate(Timestamp lastUpdate) {
        // TODO: Implement the method logic
        return null;
    }

    public List<Actor> findByLastUpdateGreaterThanEqualOrderByLastUpdate(java.sql.Timestamp timestamp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByLastUpdateGreaterThanEqualOrderByLastUpdate'");
    }

    public Actor insert(Actor actor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    public Actor update(Actor actor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
