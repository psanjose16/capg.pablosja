package com.example.domains.contracts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.domains.entities.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
}