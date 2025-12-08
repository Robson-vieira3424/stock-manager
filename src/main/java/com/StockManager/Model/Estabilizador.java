package com.StockManager.Model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Estabilizador extends EquipamentoBase{

    private String potencia;
}
