package com.StockManager.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // INDICA AO JPA QUE MÃE E FILHOS SAO UNIDOS PELO ID
public abstract class EquipamentoBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patrimonio;

    private String marca;

    private String modelo;

    @Enumerated(EnumType.STRING)
    private StatusEquipamento statusEquipamento;

    @ManyToOne
    @JoinColumn(name = "secretaria_id")
    private Secretaria secretaria;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
}
