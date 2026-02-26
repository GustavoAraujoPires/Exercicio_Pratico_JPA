package https.github.com.GustavoAraujoPires.projetoPratico.model;

import jakarta.persistence.*;


import java.util.List;
import java.util.UUID;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_usuario",unique = true)
    private UUID id;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Pedido> listaDePedidos;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pedido> getListaDePedidos() {
        return listaDePedidos;
    }

    public void setListaDePedidos(List<Pedido> listaDePedidos) {
        this.listaDePedidos = listaDePedidos;
    }
}
