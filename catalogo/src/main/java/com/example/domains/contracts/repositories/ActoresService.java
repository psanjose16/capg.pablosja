package com.example.domains.contracts.repositories;

import org.springframework.stereotype.Service;

import com.example.domains.core.contracts.services.DomainService;
import com.example.domains.entities.Actor;


public interface ActoresService extends DomainService<Actor, Integer> {
    void repartePremio();
}
