package com.StockManager.Model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Entity
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Monitor extends EquipamentoBase {

    private String tamanho;


}
