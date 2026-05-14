package com.github.GustavoAraujoPires.projetoPratico.service;

import com.github.GustavoAraujoPires.projetoPratico.dto.PedidoDTO;
import com.github.GustavoAraujoPires.projetoPratico.exception.ClienteNaoEncontradoException;
import com.github.GustavoAraujoPires.projetoPratico.exception.PedidoInvalidoException;
import com.github.GustavoAraujoPires.projetoPratico.exception.PedidoNaoEncontradoPorIdException;
import com.github.GustavoAraujoPires.projetoPratico.model.Cliente;
import com.github.GustavoAraujoPires.projetoPratico.model.Pedido;
import com.github.GustavoAraujoPires.projetoPratico.repository.ClienteRepository;
import com.github.GustavoAraujoPires.projetoPratico.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final ClienteRepository clienteRepository;

    public Pedido salvarPedido(PedidoDTO pedidoDTO){
        Pedido pedido = pedidoDTO.toEntityPedido();
        if(pedido.getValorTotal().compareTo(BigDecimal.ZERO) <= 0){
            throw new PedidoInvalidoException();
//            throw -> lança erro em execução
        }
        Cliente cliente = clienteRepository.findById(pedidoDTO.getClienteId()).orElseThrow();
        pedido.setCliente(cliente);
            return repository.save(pedido);
    }

    public List<Pedido> buscarTodosPedido(){
        return repository.findAll();
    }

    public Pedido buscarPedidoPorId(UUID id){
        return repository.findById(id).orElseThrow(PedidoNaoEncontradoPorIdException::new);
    }

    public void deletarPedido(UUID id){
        if(!repository.existsById(id)){
            throw new PedidoNaoEncontradoPorIdException();
        }
        repository.deleteById(id);
    }

    public Pedido criarPedido(PedidoDTO pedidoDTO) {
        Cliente cliente = clienteRepository.findById(pedidoDTO.getClienteId()).orElseThrow(ClienteNaoEncontradoException::new);
        Pedido  pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(pedido.getDataPedido());
        pedido.setNomePedido(pedido.getNomePedido());
        pedido.setValorTotal(pedido.getValorTotal());

        return repository.save(pedido);

    }

}
