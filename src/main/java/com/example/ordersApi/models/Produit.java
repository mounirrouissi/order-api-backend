package com.example.ordersApi.models;

//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ApiModelProperty(notes = "The database generated product ID")

    private  Long id;

    private String code;
    private String marque;
    private String modele;
    private String caracteritique;
    private BigDecimal prixUnitaire;
    private Long quantite;
    @ManyToOne
    @JoinColumn(name = "categorie_code")
    private Categorie categorie;
    @OneToMany(mappedBy = "produit")
    private Set<LignCommande> lignCommandes;
}
