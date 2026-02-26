package https.github.com.GustavoAraujoPires.projetoPratico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_usuario",unique = true)
    private UUID id;

    @Column(name = "Nome_usuario", nullable = false)
    private String name;

    @Column(name = "Email_usuario",nullable = false,unique = true)
    private String email;

    @OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY)
    private List<Pedido> listaDePedidos;
}
