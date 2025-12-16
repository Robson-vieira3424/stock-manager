package com.StockManager.Repositories;

import com.StockManager.Model.EquipamentoBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EquipamentoBaseRepository extends JpaRepository<EquipamentoBase, Long > {


    Optional<EquipamentoBase> findByPatrimonio(String patrimonio);
}
