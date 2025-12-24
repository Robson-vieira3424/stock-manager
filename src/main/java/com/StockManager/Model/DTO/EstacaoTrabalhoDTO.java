package com.StockManager.Model.DTO;

import com.StockManager.Model.*;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Data
public class EstacaoTrabalhoDTO {

    private Long Id;

    private Long secretariaId;

    private Long departamentoId;

    private ComputadorDTO computador;

    private MonitorDTO monitor ;

    private EstabilizadorDTO estabilizador;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataUltimaAlteracao;
}
