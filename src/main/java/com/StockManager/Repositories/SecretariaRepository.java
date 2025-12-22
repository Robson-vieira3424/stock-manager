package com.StockManager.Repositories;

import com.StockManager.Model.Secretaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SecretariaRepository extends JpaRepository< Secretaria,Long> {
}
