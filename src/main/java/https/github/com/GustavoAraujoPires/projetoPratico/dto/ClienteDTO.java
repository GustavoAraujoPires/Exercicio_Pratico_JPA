package https.github.com.GustavoAraujoPires.projetoPratico.dto;

import https.github.com.GustavoAraujoPires.projetoPratico.model.Cliente;
import lombok.Data;


@Data
public class ClienteDTO {

    private String nome;
    private String email;
    private String cpf;

    public Cliente toEntity(){
        Cliente cliente = new Cliente();
        cliente.setEmail(this.email);
        cliente.setName(this.nome);
        cliente.setCpf(this.cpf);

        return cliente;
    }
}
