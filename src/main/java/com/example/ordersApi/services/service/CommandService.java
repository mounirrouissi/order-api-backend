package com.example.ordersApi.services.service;

import com.example.ordersApi.models.Commande;

import java.util.List;

public interface CommandService {
    List<Commande> getAllCommandes();
    Commande getCommande(Long id);
    void addCommande(Commande client);
    void removeCommande(Long clientId);

}
