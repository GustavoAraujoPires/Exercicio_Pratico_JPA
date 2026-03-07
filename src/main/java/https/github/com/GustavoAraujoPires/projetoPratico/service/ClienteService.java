package https.github.com.GustavoAraujoPires.projetoPratico.service;

import https.github.com.GustavoAraujoPires.projetoPratico.dto.ClienteDTO;
import https.github.com.GustavoAraujoPires.projetoPratico.exception.ClienteJaExistenteException;
import https.github.com.GustavoAraujoPires.projetoPratico.exception.ClienteNaoEncontradoException;
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

    public Cliente salvarCliente(ClienteDTO clienteDTO){
        Cliente cliente = clienteDTO.toEntity();
        if(repository.existsByEmail(cliente.getEmail()) || repository.existsByCpf(cliente.getCpf())){
            throw new ClienteJaExistenteException();
        }
            return repository.save(cliente);
    }

    public Cliente buscarClientePorId(UUID id){
        return repository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException());
//        () -> é uma lambda, que só cria a exception se o valor não existir.
    }

    public void deletarCliente(UUID id){
        repository.deleteById(id);
    }

}
