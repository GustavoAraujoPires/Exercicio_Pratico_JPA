package https.github.com.GustavoAraujoPires.projetoPratico.controller;

import https.github.com.GustavoAraujoPires.projetoPratico.dto.ClienteDTO;
import https.github.com.GustavoAraujoPires.projetoPratico.model.Cliente;
import https.github.com.GustavoAraujoPires.projetoPratico.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("clientes")
@AllArgsConstructor
public class ClienteController {

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

    @DeleteMapping("/{cpf}")
    public void deletarCliente(@PathVariable String cpf){
        service.deletarCliente(cpf);
    }
}
