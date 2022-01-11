package com.example.ordersApi.dto;

//import io.swagger.annotations.ApiModelProperty;
import com.example.ordersApi.models.Client;
import com.example.ordersApi.models.LignCommande;
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

public class CommandeDto {

    private  Long id;

    private String numero;
    private LocalDate date;
    private BigDecimal prixUnitaire;
    private Long etat;
    private List<LignCommande> lignCommande;
    private Client client;

    public CommandeDto(String numero) {
        this.numero = numero;
    }
       public CommandeDto(Long id, String numero) {
        this.id=id;
        this.numero = numero;
    }

}
