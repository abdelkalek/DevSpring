package com.example.exercice1devops.service;
import com.example.exercice1devops.entity.Client;
public interface IClientService {
    Client addClient(Client c);
    void delete(Long id);
    Iterable<Client> listebyName();
}
