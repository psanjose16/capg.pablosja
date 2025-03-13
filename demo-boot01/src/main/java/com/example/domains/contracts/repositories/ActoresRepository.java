package com.example.domains.contracts.repositories;
import org.springframework.data.jpa.stereotype.JpaRepository;
import com.example.domains.entities.Actor;

public interface ActoresRepository extends JpaRepository<Actor, Integer> {

	Object findAll();

}
