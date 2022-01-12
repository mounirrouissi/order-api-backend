package com.example.ordersApi.services.serviceImpl;

import com.example.ordersApi.controller.exceptions.ProduitNotFoundException;
import com.example.ordersApi.models.Produit;
import com.example.ordersApi.repositories.ProduitRepo;
import com.example.ordersApi.services.service.ProduitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {
    private  final ProduitRepo clientRepo;

    public ProduitServiceImpl(ProduitRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public List<Produit> getAllProduits() {
        return this.clientRepo.findAll();
    }

    @Override
    public Produit getProduit(Long id) {
        return this.clientRepo.findById(id).orElseThrow(ProduitNotFoundException::new);

    }

    @Override
    public void addProduit(Produit client) {
        this.clientRepo.save(client);

    }

    @Override
    public void removeProduit(Long clientId) {
    this.clientRepo.delete(this.clientRepo.findById(clientId).orElseThrow());

    }

}
