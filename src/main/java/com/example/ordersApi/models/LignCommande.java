package com.example.ordersApi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LignCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ApiModelProperty(notes = "The database generated product ID")
    private  Long id;
    private Long quantite;
    private BigDecimal prixUnitaire;
    private BigDecimal prixTotal;
    private Long etat;
    @ManyToOne
    @JoinColumn(name = "produit_code")
    private Produit produit;
    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

}
