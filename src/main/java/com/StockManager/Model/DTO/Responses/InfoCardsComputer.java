package com.StockManager.Model.DTO.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoCardsComputer {
    private String totalComputadores;
    private String totalAtivos;
    private String totalManutencao;
    private String totalInativos;

    @Override
    public String toString() {
        return "InfoCardsComputer{" +
                "totalComputadores='" + totalComputadores + '\'' +
                ", totalAtivos='" + totalAtivos + '\'' +
                ", totalManutencao='" + totalManutencao + '\'' +
                ", totalInativos='" + totalInativos + '\'' +
                '}';
    }
}
