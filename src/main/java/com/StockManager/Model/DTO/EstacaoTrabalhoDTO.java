package com.StockManager.Model.DTO;

import com.StockManager.Model.Computador;
import com.StockManager.Model.Estabilizador;
import com.StockManager.Model.Monitor;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Data
public class EstacaoTrabalhoDTO {

    private Long Id;

    private String secretaria;

    private String setor;

    private ComputadorDTO computador;

    private MonitorDTO monitor ;

    private EstabilizadorDTO estabilizador;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataUltimaAlteracao;
}
