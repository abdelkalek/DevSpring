package com.example.exercice1devops.controller;

import com.example.exercice1devops.entity.Client;

public interface IClientController {
    Iterable<Client> getClients();
    Client addClient(Object c) ;
    void removeClient(Long clientId);
}
