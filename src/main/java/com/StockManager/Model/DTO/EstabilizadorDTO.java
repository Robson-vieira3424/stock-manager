package com.StockManager.Model.DTO;

import com.StockManager.Model.StatusEquipamento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class EstabilizadorDTO {
    private Long id;

    private String patrimonio;

    private String marca;

    private String modelo;

    private StatusEquipamento statusEquipamento;

    private String potencia;
}
