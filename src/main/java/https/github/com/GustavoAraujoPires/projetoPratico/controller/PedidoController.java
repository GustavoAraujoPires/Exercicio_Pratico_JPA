package https.github.com.GustavoAraujoPires.projetoPratico.controller;

import https.github.com.GustavoAraujoPires.projetoPratico.dto.PedidoDTO;
import https.github.com.GustavoAraujoPires.projetoPratico.model.Pedido;
import https.github.com.GustavoAraujoPires.projetoPratico.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("pedidos")
@AllArgsConstructor
public class PedidoController {

    private PedidoService service;

    @PostMapping
    public Pedido savarPedido(@RequestBody PedidoDTO pedidoDTO){
        return service.salvarPedido(pedidoDTO);
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
