package com.example.ordersApi.dto;

//import io.swagger.annotations.ApiModelProperty;
import com.example.ordersApi.models.Produit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategorieDto {
    private  Long id;
    private String code;
    private String libelle;
    private List<Produit> produits;
}
