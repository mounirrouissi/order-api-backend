package com.example.ordersApi.repositories;

import com.example.ordersApi.models.Client;
import com.example.ordersApi.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CommandeRepo extends JpaRepository<Commande,Long> {
}
