package com.github.GustavoAraujoPires.projetoPratico.controller;

import com.github.GustavoAraujoPires.projetoPratico.dto.ClienteDTO;
import com.github.GustavoAraujoPires.projetoPratico.dto.Erros;
import com.github.GustavoAraujoPires.projetoPratico.exception.ClienteNaoEncontradoException;
import com.github.GustavoAraujoPires.projetoPratico.model.Cliente;
import com.github.GustavoAraujoPires.projetoPratico.service.ClienteService;
import com.github.GustavoAraujoPires.projetoPratico.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;
    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity salvar(@RequestBody @Valid ClienteDTO cliente){
        try {
            Cliente clienteEntidade = cliente.toEntity();
                 service.salvar(clienteEntidade);
            URI localtion = ServletUriComponentsBuilder
                    .fromCurrentRequestUri()
                    .path("id").buildAndExpand(clienteEntidade.getId()).toUri();
            return ResponseEntity.created(localtion).build();
        }catch (ClienteNaoEncontradoException e){
            var erro = Erros.RespostaPadrao(e.getMessage());
            return ResponseEntity.status(erro.status()).body(erro.mensagem());
        }
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodos() {
        List<Cliente> clientes = service.buscarTodosClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable @Valid String id){
        var idCliente = UUID.fromString(id);
        Optional<Cliente> clienteOptional = service.buscarClientePorId(idCliente);
        if (clienteOptional.isPresent()){
            Cliente cliente = clienteOptional.get();
            ClienteDTO dto = new ClienteDTO(
            cliente.getName(),
            cliente.getEmail(),
            cliente.getCpf());
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cpf}")
    public void deletarCliente(@PathVariable @Valid String cpf){
        service.deletarCliente(cpf);
    }


}

