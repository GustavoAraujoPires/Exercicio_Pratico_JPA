package com.github.GustavoAraujoPires.projetoPratico.repository;


import com.github.GustavoAraujoPires.projetoPratico.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente,UUID> {

   List<Cliente> findByEmail(String email);
   List<Cliente> existsByEmail(String email);
   List<Cliente> findByName(String name);
   boolean existsByCpf(String cpf);
   void deleteByCpf(String cpf);
   List<Cliente> findByNameAndEmail(String name, String email);
}
