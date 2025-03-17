package com.example.domains.contracts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domains.contracts.repositories.ActorRepository;
import com.example.domains.entities.Actor;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    public Optional<Actor> findById(int id) {
        return actorRepository.findById(id);
    }

    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    public void deleteById(int id) {
        actorRepository.deleteById(id);
    }

    public Actor update(Actor actor) {
        if (actorRepository.existsById(actor.getActorId())) {
            return actorRepository.save(actor);
        } else {
            throw new RuntimeException("Actor not found");
        }
    }
}