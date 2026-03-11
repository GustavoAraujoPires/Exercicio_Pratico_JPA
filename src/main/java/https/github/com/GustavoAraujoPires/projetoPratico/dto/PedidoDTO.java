package https.github.com.GustavoAraujoPires.projetoPratico.dto;

import https.github.com.GustavoAraujoPires.projetoPratico.model.Cliente;
import https.github.com.GustavoAraujoPires.projetoPratico.model.Pedido;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


@Data
public class PedidoDTO {

    private String nomePedido;
    private LocalDate dataPedido;
    private BigDecimal valorTotal;
    private UUID ClienteId;

    public Pedido toEntityPedido(){
        Pedido pedido = new Pedido();
        pedido.setNomePedido(this.nomePedido);
        pedido.setDataPedido(this.dataPedido);
        pedido.setValorTotal(this.valorTotal);
        return pedido;
    }
}
