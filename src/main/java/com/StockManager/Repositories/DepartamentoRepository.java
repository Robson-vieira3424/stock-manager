package com.StockManager.Repositories;

import com.StockManager.Model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    List<Departamento> findBySecretariaId(Long secretairaId);

    Departamento findByNome(String nome);
}
