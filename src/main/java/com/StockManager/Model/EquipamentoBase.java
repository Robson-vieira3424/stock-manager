package com.StockManager.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass  // Indica ao JPA que essa classe não sera uma entidade, apenas um molde para os filhos que serão
public abstract class EquipamentoBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patrimonio;

    private String marca;

    private String modelo;

    @Enumerated(EnumType.STRING)
    private StatusEquipamento statusEquipamento;
}
