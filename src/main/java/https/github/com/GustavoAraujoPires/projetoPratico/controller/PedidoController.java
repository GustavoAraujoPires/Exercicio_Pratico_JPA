package https.github.com.GustavoAraujoPires.projetoPratico.controller;

import https.github.com.GustavoAraujoPires.projetoPratico.model.Cliente;
import https.github.com.GustavoAraujoPires.projetoPratico.model.Pedido;
import https.github.com.GustavoAraujoPires.projetoPratico.repository.ClienteRepository;
import https.github.com.GustavoAraujoPires.projetoPratico.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public Pedido savarPedido(@RequestBody Pedido pedido){
        UUID id = pedido.getCliente().getId();
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado !!"));
        pedido.setCliente(cliente);
        return service.salvarPedido(pedido);
    }

    @GetMapping
    public List<Pedido> listarTodos(){
        return service.buscarTodosPedido();
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable UUID id){
        return service.buscarPedidoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable UUID id){
        service.deletarPedido(id);
    }
}
