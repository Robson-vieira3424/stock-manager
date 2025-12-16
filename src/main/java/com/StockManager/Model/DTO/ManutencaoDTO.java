package com.StockManager.Model.DTO;

import com.StockManager.Model.EquipamentoBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManutencaoDTO {

    private EquipamentoBase equipamento;

    private String patrimonio;

    private Boolean necessitaPeca;

    private String descricaoProblema;

    private String tipo;

    private String prioridade;

    private Date previsaoRetorno;

    private List<String> pecasUtilizadas;

    private String observacao;

    private String dataPrevisao;


}
