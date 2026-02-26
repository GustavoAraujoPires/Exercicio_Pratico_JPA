package https.github.com.GustavoAraujoPires.projetoPratico.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_usuario",unique = true)
    private long UUID;

    @Column(name = "Nome_usuario", nullable = false)
    private String name;

    @Column(name = "Email_usuario",nullable = false)
    private String email;

}
