package https.github.com.GustavoAraujoPires.projetoPratico.controller;

import https.github.com.GustavoAraujoPires.projetoPratico.dto.ClienteDTO;
import https.github.com.GustavoAraujoPires.projetoPratico.model.Cliente;
import https.github.com.GustavoAraujoPires.projetoPratico.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public Cliente salvar(@RequestBody ClienteDTO clienteDTO){
         return service.salvarCliente(clienteDTO);
    }

    @GetMapping
    public List<Cliente> buscarTodos(){
        return service.buscarTodosClientes();
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable UUID id){
        return service.buscarClientePorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable UUID id){
        service.deletarCliente(id);
    }
}
