package com.github.GustavoAraujoPires.projetoPratico.repository;

import com.github.GustavoAraujoPires.projetoPratico.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
    boolean existsById(UUID id);
}
