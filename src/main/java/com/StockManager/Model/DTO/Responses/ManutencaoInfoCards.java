package com.StockManager.Model.DTO.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManutencaoInfoCards {

    private String total;

    private String emAndamento;

    private String aguardandoPeca;

    private String concluido;

    private String baixado;


}
