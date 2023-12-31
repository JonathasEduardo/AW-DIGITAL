package com.awdigital.awDigital.repositorys;

import com.awdigital.awDigital.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByNomeCliente(String nomeCliente);
    Optional<Cliente> findByNomeClienteContaining(String nomeCliente);
}
