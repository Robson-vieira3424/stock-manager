package com.StockManager.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
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
