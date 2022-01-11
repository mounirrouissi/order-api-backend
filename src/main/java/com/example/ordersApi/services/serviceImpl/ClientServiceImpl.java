package com.example.ordersApi.services.serviceImpl;

import com.example.ordersApi.controller.exceptions.ClientNotFoundException;
import com.example.ordersApi.models.Client;
import com.example.ordersApi.repositories.ClientRepo;
import com.example.ordersApi.services.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private  final ClientRepo clientRepo;

    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public List<Client> getAllClients() {
        return this.clientRepo.findAll();
    }

    @Override
    public Client getClient(Long id) {
        return this.clientRepo.findById(id).orElseThrow(ClientNotFoundException::new);

    }

    @Override
    public void addClient(Client client) {
        this.clientRepo.save(client);

    }

    @Override
    public void removeClient(Long clientId) {
    this.clientRepo.delete(this.clientRepo.findById(clientId).orElseThrow());

    }

}
