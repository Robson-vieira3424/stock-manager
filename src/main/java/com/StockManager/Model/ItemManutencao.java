package com.StockManager.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemManutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "manutencao_id")
    private Manutencao manutencao;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product produto;

    private Long quantidadeUtilizada;
}
