package com.example.ordersApi.repositories;

import com.example.ordersApi.models.Categorie;
import com.example.ordersApi.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CategoryRepo extends JpaRepository<Categorie,Long> {
}
