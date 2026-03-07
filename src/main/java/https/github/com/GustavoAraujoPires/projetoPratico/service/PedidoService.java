package https.github.com.GustavoAraujoPires.projetoPratico.service;

import https.github.com.GustavoAraujoPires.projetoPratico.dto.PedidoDTO;
import https.github.com.GustavoAraujoPires.projetoPratico.exception.PedidoInvalidoException;
import https.github.com.GustavoAraujoPires.projetoPratico.model.Cliente;
import https.github.com.GustavoAraujoPires.projetoPratico.model.Pedido;
import https.github.com.GustavoAraujoPires.projetoPratico.repository.ClienteRepository;
import https.github.com.GustavoAraujoPires.projetoPratico.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@Service
@NoArgsConstructor
@AllArgsConstructor
public class PedidoService {


    private PedidoRepository repository;

    private ClienteRepository clienteRepository;

    public Pedido salvarPedido(PedidoDTO pedidoDTO){
        Pedido pedido = pedidoDTO.toEntityPedido();
        if(pedido.getValorTotal().compareTo(BigDecimal.ZERO) <= 0){
            throw new PedidoInvalidoException();
//            throw -> lança erro e para execução
        }else
            return repository.save(pedido);

    }

    public List<Pedido> buscarTodosPedido(){
        return repository.findAll();
    }

    public Pedido buscarPedidoPorId(UUID id){
        return repository.findById(id).orElse(null);
    }

    public void deletarPedido(UUID id){
        repository.deleteById(id);
    }

}
