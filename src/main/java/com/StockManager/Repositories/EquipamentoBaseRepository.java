package com.StockManager.Repositories;

import com.StockManager.Model.EquipamentoBase;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EquipamentoBaseRepository extends JpaRepository<EquipamentoBase, Long >, JpaSpecificationExecutor<EquipamentoBase> {


    Optional<EquipamentoBase> findByPatrimonio(String patrimonio);
}
