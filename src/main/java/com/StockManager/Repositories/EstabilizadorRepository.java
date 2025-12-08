package com.StockManager.Repositories;

import com.StockManager.Model.Estabilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstabilizadorRepository extends JpaRepository<Estabilizador, Long> {
}
