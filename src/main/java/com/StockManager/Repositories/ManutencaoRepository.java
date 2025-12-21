package com.StockManager.Repositories;

import com.StockManager.Model.Manutencao;
import jakarta.persistence.Enumerated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {

    Long countByStatus(String status);
}
