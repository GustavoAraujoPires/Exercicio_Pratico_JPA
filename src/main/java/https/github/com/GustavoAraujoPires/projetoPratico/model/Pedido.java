package https.github.com.GustavoAraujoPires.projetoPratico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;

    private Data dataPedido;

    private Double valorTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Cliente")
    private Cliente cliente;


}
