package com.awdigital.awDigital.repositorys;

import com.awdigital.awDigital.models.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LojaRepository extends JpaRepository<Loja,Integer> {


    Optional<Loja> findByNomeLoja(String nomeLoja);
    @Query(value = "SELECT obj FROM Loja obj WHERE obj.cliente.idCliente = :id_loja")
    List<Loja> findAllByCliente(@Param(value = "id_loja") Integer id_loja);


    List<Loja>findByNomeLojaContaining(String nomeLoja);
}
