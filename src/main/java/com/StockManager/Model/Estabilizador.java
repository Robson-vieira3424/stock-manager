package com.StockManager.Model;

import jakarta.persistence.Entity;
import lombok.*;

@Setter
@Entity
@Getter
@NoArgsConstructor
public class Estabilizador extends EquipamentoBase{


    private String potencia;

}
