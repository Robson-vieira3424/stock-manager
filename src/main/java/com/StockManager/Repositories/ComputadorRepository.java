package com.StockManager.Repositories;

import com.StockManager.Model.Computador;
import com.StockManager.Model.StatusEquipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputadorRepository extends JpaRepository<Computador, Long> {

    long countByStatusEquipamento(StatusEquipamento status);
}
