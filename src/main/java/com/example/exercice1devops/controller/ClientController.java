package com.example.exercice1devops.controller;

import com.example.exercice1devops.entity.Client;
import com.example.exercice1devops.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/client")
public class ClientController implements IClientController {
    @Autowired
    private ClientService clientService;
    @Override
    @GetMapping("")
    @ResponseBody
    public Iterable<Client> getClients() {
        return clientService.listebyName();
    }
    @PostMapping
    public Client addClient(@RequestBody Object c) {
        Client x = (Client) c;
        return clientService.addClient(x);
    }

    @Override
    @DeleteMapping("/remove/{id}")
    @ResponseBody
    public void removeClient(@PathVariable("id") Long clientId) {
        clientService.delete(clientId);
    }


}
