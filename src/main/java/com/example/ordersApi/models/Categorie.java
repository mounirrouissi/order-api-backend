package com.example.ordersApi.models;

//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ApiModelProperty(notes = "The database generated product ID")
    private  Long id;
    private String code;
    private String libelle;
@OneToMany(mappedBy = "categorie")
    private List<Produit> produits;
}
