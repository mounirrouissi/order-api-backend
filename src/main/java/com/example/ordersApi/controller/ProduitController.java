package com.example.ordersApi.controller;

import com.example.ordersApi.controller.exceptions.ProduitNotFoundException;
import com.example.ordersApi.models.Produit;
import com.example.ordersApi.services.serviceImpl.ProduitServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/v1/produits")
@Tag(name=" Produit Controller",description = "this is Produit Controller endpoint")
@CrossOrigin("*")
public class ProduitController {
    private final ProduitServiceImpl produitService;

    public ProduitController(ProduitServiceImpl produitService) {
        this.produitService = produitService;
    }


    @GetMapping
    public ResponseEntity<List<Produit>> getAllProduits() {
        return ResponseEntity.status(HttpStatus.OK).body(produitService.getAllProduits());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduit(@PathVariable("id") Long id) {
        try {
            System.out.println("id="+id);
            var client = this.produitService.getProduit(id);
            return ResponseEntity.status(HttpStatus.OK).body(client);
        } catch (ProduitNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"produit not found",e
            );
        }
    }


    @PostMapping
    public ResponseEntity<Produit> addProduit(@RequestBody Produit client) {
        this.produitService.addProduit(client);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }
@GetMapping("/delete/{id}")
    public ResponseEntity removeProduit(@PathParam("id") Long clientId) {
        this.produitService.removeProduit(clientId);
        return ResponseEntity.status(HttpStatus.GONE).body(clientId);
    }
}
