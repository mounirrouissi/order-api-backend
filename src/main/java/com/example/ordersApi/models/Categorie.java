package com.example.ordersApi.models;

//import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@JsonIgnore
    private List<Produit> produits;
}
