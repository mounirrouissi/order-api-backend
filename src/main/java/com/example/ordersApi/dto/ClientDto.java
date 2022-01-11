package com.example.ordersApi.dto;

//import io.swagger.annotations.ApiModelProperty;
import com.example.ordersApi.models.Commande;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ClientDto {

    private  Long id;
    private String code;
    private String nom;
    private String prenom;
    private LocalDate dateNaisance;
    private String address;
    private String ville;
    private Long codePostal;
    private String tel;
    private String fax;
    private String gsm;
    private String email;
    private List<Commande> commandes;

}
