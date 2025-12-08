package com.StockManager.Model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Monitor extends EquipamentoBase {

    private String tamanho;

    public Monitor(String tamanho) {
        this.tamanho = tamanho;
    }

    public Monitor(){}
}
