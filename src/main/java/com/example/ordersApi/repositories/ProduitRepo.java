package com.example.ordersApi.repositories;

import com.example.ordersApi.models.Client;
import com.example.ordersApi.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepo extends JpaRepository<Produit,Long> {
}
