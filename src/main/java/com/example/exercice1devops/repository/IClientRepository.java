package com.example.exercice1devops.repository;

import com.example.exercice1devops.entity.Client;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClientRepository extends JpaRepository<Client, Long> {
    Iterable<Client> findClientByNom(String nom);
    Optional<Client> findClientByEmail(String email);
}
