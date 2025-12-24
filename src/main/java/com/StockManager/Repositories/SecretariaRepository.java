package com.StockManager.Repositories;

import com.StockManager.Model.Secretaria;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SecretariaRepository extends JpaRepository< Secretaria,Long> {

    @EntityGraph(attributePaths = "departamentos")
    List<Secretaria> findAll();

    Secretaria findByNome(String nome);
}
