package com.StockManager.Model;

import jakarta.persistence.Entity;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Computador extends EquipamentoBase{

    private String processador;

    private String memoria;

    private String armazenamento;

    private String tipo;

    private String Sistema;

    private String nome;
}
