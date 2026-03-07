package https.github.com.GustavoAraujoPires.projetoPratico.dto;

import https.github.com.GustavoAraujoPires.projetoPratico.model.Cliente;
import https.github.com.GustavoAraujoPires.projetoPratico.model.Pedido;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
public class PedidoDTO {

    private String nomePedido;
    private LocalDate dataPedido;
    private BigDecimal valorTotal;
    private Cliente cliente;

    public Pedido toEntityPedido(){
        Pedido pedido = new Pedido();
        pedido.setNomePedido(this.nomePedido);
        pedido.setDataPedido(this.dataPedido);
        pedido.setValorTotal(this.valorTotal);
        pedido.setCliente(this.cliente);

        return pedido;

    }
}
