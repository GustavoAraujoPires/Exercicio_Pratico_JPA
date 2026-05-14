package com.github.GustavoAraujoPires.projetoPratico.model;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;

    private String nomePedido;

    private LocalDate dataPedido;

    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "ClienteId")
    private Cliente cliente;
}
