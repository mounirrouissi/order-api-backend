package com.example.ordersApi.services.serviceImpl;

import com.example.ordersApi.controller.exceptions.CategoryNotFoundException;
import com.example.ordersApi.controller.exceptions.ClientNotFoundException;
import com.example.ordersApi.models.Categorie;
import com.example.ordersApi.models.Client;
import com.example.ordersApi.repositories.CategoryRepo;
import com.example.ordersApi.repositories.ClientRepo;
import com.example.ordersApi.services.service.CategoryService;
import com.example.ordersApi.services.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private  final CategoryRepo clientRepo;

    public CategoryServiceImpl(CategoryRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public List<Categorie> getAllCategorys() {
        return this.clientRepo.findAll();
    }

    @Override
    public Categorie getCategory(Long id) {
        return this.clientRepo.findById(id).orElseThrow(CategoryNotFoundException::new);

    }

    @Override
    public void addCategory(Categorie client) {
        this.clientRepo.save(client);

    }

    @Override
    public void removeCategory(Long clientId) {
    this.clientRepo.delete(this.clientRepo.findById(clientId).orElseThrow());

    }

}
