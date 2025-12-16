package com.StockManager.Model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Estabilizador extends EquipamentoBase{


    private String potencia;

    public Estabilizador (String potencia){
        super();
        this.potencia = potencia;
    }
}
