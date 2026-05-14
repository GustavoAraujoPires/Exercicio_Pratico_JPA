package com.github.GustavoAraujoPires.projetoPratico.controller;

import com.github.GustavoAraujoPires.projetoPratico.dto.PedidoDTO;
import com.github.GustavoAraujoPires.projetoPratico.exception.PedidoInvalidoException;
import com.github.GustavoAraujoPires.projetoPratico.model.Pedido;
import com.github.GustavoAraujoPires.projetoPratico.service.PedidoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;


    @PostMapping
    public ResponseEntity<Pedido> savarPedido(@RequestBody PedidoDTO pedidoDTO){
            Pedido pedido = service.salvarPedido(pedidoDTO);
            return ResponseEntity.ok(pedido);
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

