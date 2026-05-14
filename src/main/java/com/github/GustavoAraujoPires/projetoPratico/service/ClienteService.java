package com.github.GustavoAraujoPires.projetoPratico.service;

import com.github.GustavoAraujoPires.projetoPratico.exception.ClienteNaoEncontradoException;
import com.github.GustavoAraujoPires.projetoPratico.model.Cliente;
import com.github.GustavoAraujoPires.projetoPratico.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteService {

   private final ClienteRepository repository;

    public Cliente salvar (Cliente cliente){
        return repository.save(cliente);
    }

    public List<Cliente> buscarTodosClientes() {
        return repository.findAll();
    }

    public Optional<Cliente> buscarClientePorId (UUID id){
            return repository.findById(id);
    }

        @Transactional
        public void deletarCliente (String cpf){
            if (!repository.existsByCpf(cpf)) {
                 throw new ClienteNaoEncontradoException();
            }
            repository.deleteByCpf(cpf);
        }
    }

