package com.example.ordersApi.services.service;

import com.example.ordersApi.models.Produit;

import java.util.List;

public interface ProduitService {
    List<Produit> getAllProduits();
    Produit getProduit(Long id);
    void addProduit(Produit client);
    void removeProduit(Long clientId);

}
