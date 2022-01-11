package com.example.ordersApi.models;

//import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ApiModelProperty(notes = "The database generated product ID")
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
    @OneToMany(mappedBy = "client")
    private Set<Commande> commandes;

    public Client(String code, String nom, String prenom, LocalDate dateNaisance, String address, String ville, Long codePostal, String tel, String fax, String gsm, String email) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaisance = dateNaisance;
        this.address = address;
        this.ville = ville;
        this.codePostal = codePostal;
        this.tel = tel;
        this.fax = fax;
        this.gsm = gsm;
        this.email = email;
    }
}
