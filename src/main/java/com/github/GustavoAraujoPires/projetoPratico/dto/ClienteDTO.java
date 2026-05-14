package com.github.GustavoAraujoPires.projetoPratico.dto;

import com.github.GustavoAraujoPires.projetoPratico.model.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class ClienteDTO{
    

        @NotBlank(message = "Campo Obrigatorio")
        private String name;
        @NotBlank(message = "Campo Obrigatorio")
        @Email
        private String email;
        @NotBlank(message = "Campo Obrigatorio")
        @CPF
        private String cpf;

    public ClienteDTO(String name, String email, String cpf) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public Cliente toEntity(){
        Cliente cliente = new Cliente();
        cliente.setEmail(this.email);
        cliente.setName(this.name);
        return cliente;
    }
}

