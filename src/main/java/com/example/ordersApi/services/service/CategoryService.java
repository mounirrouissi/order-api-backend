package com.example.ordersApi.services.service;

import com.example.ordersApi.models.Categorie;
import com.example.ordersApi.models.Client;

import java.util.List;

public interface CategoryService {
    List<Categorie> getAllCategorys();
    Categorie getCategory(Long id);
    void addCategory(Categorie client);
    void removeCategory(Long clientId);

}
