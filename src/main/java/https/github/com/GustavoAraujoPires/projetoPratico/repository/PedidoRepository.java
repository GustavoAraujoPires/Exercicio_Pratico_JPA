package https.github.com.GustavoAraujoPires.projetoPratico.repository;

import https.github.com.GustavoAraujoPires.projetoPratico.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
}
