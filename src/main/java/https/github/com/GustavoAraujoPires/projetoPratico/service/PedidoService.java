package https.github.com.GustavoAraujoPires.projetoPratico.service;

import https.github.com.GustavoAraujoPires.projetoPratico.dto.PedidoDTO;
import https.github.com.GustavoAraujoPires.projetoPratico.exception.PedidoInvalidoException;
import https.github.com.GustavoAraujoPires.projetoPratico.exception.PedidoNaoEncontradoPorIdException;
import https.github.com.GustavoAraujoPires.projetoPratico.model.Pedido;
import https.github.com.GustavoAraujoPires.projetoPratico.repository.PedidoRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class PedidoService {

    private PedidoRepository repository;

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
        return repository.findById(id).orElseThrow(
                () -> new PedidoNaoEncontradoPorIdException());
    }

    public void deletarPedido(UUID id){
        if(!repository.existsById(id)){
            throw new PedidoNaoEncontradoPorIdException();
        }
        repository.deleteById(id);
    }
}
