package https.github.com.GustavoAraujoPires.projetoPratico.service;

import https.github.com.GustavoAraujoPires.projetoPratico.model.Cliente;
import https.github.com.GustavoAraujoPires.projetoPratico.model.Pedido;
import https.github.com.GustavoAraujoPires.projetoPratico.repository.ClienteRepository;
import https.github.com.GustavoAraujoPires.projetoPratico.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Pedido salvarPedido(Pedido pedido){
        UUID clienteId = pedido.getCliente().getId();
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente não encontrado !!!"));
        pedido.setCliente(cliente);
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
