package https.github.com.GustavoAraujoPires.projetoPratico.repository;

import https.github.com.GustavoAraujoPires.projetoPratico.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente,UUID>{
}
