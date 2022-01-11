package com.example.ordersApi.models;

//import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity

public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ApiModelProperty(notes = "The database generated product ID")

    private  Long id;

    private String numero;
    private LocalDate date;
    private BigDecimal prixUnitaire;
    private Long etat;
    @OneToMany(mappedBy = "commande")
    private List<LignCommande> lignCommande;
    @ManyToOne
    @JoinColumn(name = "client_code")
    private Client client;

    public Commande(String numero) {
        this.numero = numero;
    }
       public Commande(Long id,String numero) {
        this.id=id;
        this.numero = numero;
    }

}
