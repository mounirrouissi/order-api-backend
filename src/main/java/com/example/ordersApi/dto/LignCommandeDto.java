package com.example.ordersApi.dto;

import com.example.ordersApi.models.Commande;
import com.example.ordersApi.models.Produit;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

public class LignCommandeDto {
    private  Long id;
    private Long quantite;
    private BigDecimal prixUnitaire;
    private BigDecimal prixTotal;
    private Long etat;

    private Produit produit;

    private Commande commande;

}
