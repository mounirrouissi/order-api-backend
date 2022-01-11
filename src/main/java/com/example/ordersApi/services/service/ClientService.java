package com.example.ordersApi.services.service;

import com.example.ordersApi.models.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    Client getClient(Long id);
    void addClient(Client client);
    void removeClient(Long clientId);

}
