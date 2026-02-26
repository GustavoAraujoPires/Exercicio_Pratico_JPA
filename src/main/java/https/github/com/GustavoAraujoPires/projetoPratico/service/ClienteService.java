package https.github.com.GustavoAraujoPires.projetoPratico.service;

import https.github.com.GustavoAraujoPires.projetoPratico.model.Cliente;
import https.github.com.GustavoAraujoPires.projetoPratico.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public List<Cliente> buscarTodosClientes(){
        return repository.findAll();
    }

    public Cliente salvarCliente(Cliente cliente){
        return repository.save(cliente);
    }


    public Cliente buscarClientePorId(UUID id){
        return repository.findById(id).orElse(null);
    }

    public void deletarCliente(UUID id){
        repository.deleteById(id);
    }

}
