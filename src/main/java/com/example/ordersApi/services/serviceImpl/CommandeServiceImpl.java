package com.example.ordersApi.services.serviceImpl;

import com.example.ordersApi.models.Commande;
import com.example.ordersApi.services.service.CommandService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommandeServiceImpl implements CommandService {
    @Override
    public List<Commande> getAllCommandes() {
        return null;
    }

    @Override
    public Commande getCommande(Long id) {
        return null;
    }

    @Override
    public void addCommande(Commande client) {

    }

    @Override
    public void removeCommande(Long clientId) {

    }
}
