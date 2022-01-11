package com.example.ordersApi.repositories;

import com.example.ordersApi.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface    ClientRepo extends JpaRepository<Client,Long> {


    Client getClientByCode(String s);
}
