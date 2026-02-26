package https.github.com.GustavoAraujoPires.projetoPratico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long UUID;

    private Data dataPedido;

    private Double valorTotal;

    private Cliente cliente;


}
