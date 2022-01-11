package com.example.ordersApi.controller;

import com.example.ordersApi.controller.exceptions.ClientNotFoundException;
import com.example.ordersApi.models.Client;

import com.example.ordersApi.services.serviceImpl.ClientServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
@Tag(name=" Client Controller",description = "this is Client Controller endpoint")
@CrossOrigin("*")
public class ClientController {
    private final ClientServiceImpl clientService;

    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }


    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getAllClients());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") Long id) {
        try {
            System.out.println("id="+id);
            var client = this.clientService.getClient(id);
            return ResponseEntity.status(HttpStatus.OK).body(client);
        } catch (ClientNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"client not found",e
            );
        }
    }


    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        this.clientService.addClient(client);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }
@GetMapping("/delete/{id}")
    public ResponseEntity removeClient(@PathParam("id") Long clientId) {
        this.clientService.removeClient(clientId);
        return ResponseEntity.status(HttpStatus.GONE).body(clientId);
    }
}
