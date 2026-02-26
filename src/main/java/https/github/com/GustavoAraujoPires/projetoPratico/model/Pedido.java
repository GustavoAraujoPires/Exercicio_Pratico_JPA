package https.github.com.GustavoAraujoPires.projetoPratico.model;

import jakarta.persistence.*;
import lombok.Data;


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

    private Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "id_Cliente")
    private Cliente cliente;
}
