package https.github.com.GustavoAraujoPires.projetoPratico.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cpf;

    @OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Pedido> listaDePedidos;

}
