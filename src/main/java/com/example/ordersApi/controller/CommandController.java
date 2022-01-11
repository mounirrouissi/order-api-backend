package com.example.ordersApi.controller;

import com.example.ordersApi.controller.exceptions.CommandeNotFoundException;
import com.example.ordersApi.models.Commande;
import com.example.ordersApi.services.serviceImpl.CommandeServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/v1/commandes")
@Tag(name=" Commande Controller",description = "this is Commande Controller endpoint")
public class CommandController {
    private final CommandeServiceImpl clommandService;

    public CommandController(CommandeServiceImpl clommandService) {
        this.clommandService = clommandService;
    }


    @GetMapping
    public ResponseEntity<List<Commande>> getAllCommandes() {
        return ResponseEntity.status(HttpStatus.OK).body(clommandService.getAllCommandes());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommande(@PathVariable("id") Long id) {
        try {
            System.out.println("id="+id);
            var clommand = this.clommandService.getCommande(id);
            return ResponseEntity.status(HttpStatus.OK).body(clommand);
        } catch (CommandeNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"clommand not found",e
            );
        }
    }


    @PostMapping
    public ResponseEntity<Commande> addCommande(@RequestBody Commande clommand) {
        this.clommandService.addCommande(clommand);
        return ResponseEntity.status(HttpStatus.OK).body(clommand);
    }
@GetMapping("/delete/{id}")
    public ResponseEntity removeCommande(@PathParam("id") Long clommandId) {
        this.clommandService.removeCommande(clommandId);
        return ResponseEntity.status(HttpStatus.GONE).body(clommandId);
    }
}
