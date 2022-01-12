package com.example.ordersApi.controller;

import com.example.ordersApi.controller.exceptions.CategoryNotFoundException;
import com.example.ordersApi.models.Categorie;
import com.example.ordersApi.services.serviceImpl.CategoryServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
@Tag(name=" Category Controller",description = "this is Category Controller endpoint")
@CrossOrigin("*")
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public ResponseEntity<List<Categorie>> getAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategorys());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getCategory(@PathVariable("id") Long id) {
        try {
            System.out.println("id="+id);
            var category = this.categoryService.getCategory(id);
            return ResponseEntity.status(HttpStatus.OK).body(category);
        } catch (CategoryNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"category not found",e
            );
        }
    }


    @PostMapping
    public ResponseEntity<Categorie> addCategory(@RequestBody Categorie client) {
        this.categoryService.addCategory(client);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }
@GetMapping("/delete/{id}")
    public ResponseEntity removeCategory(@PathParam("id") Long clientId) {
        this.categoryService.removeCategory(clientId);
        return ResponseEntity.status(HttpStatus.GONE).body(clientId);
    }
}
