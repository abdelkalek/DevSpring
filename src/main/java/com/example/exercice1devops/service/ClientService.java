package com.example.exercice1devops.service;

import com.example.exercice1devops.entity.Client;
import com.example.exercice1devops.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {
    @Autowired
    private IClientRepository clientRepository;

    @Override
    public Client addClient(Client c) {
        return clientRepository.save(c);
    }

    public Iterable<Client> chercher(String nom) {
        return clientRepository.findClientByNom(nom);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Iterable<Client> listebyName() {
     return clientRepository.findAll(Sort.by("nom"));

    }
}
