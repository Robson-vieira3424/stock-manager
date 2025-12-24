package com.StockManager.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Data
public class EstacaoTrabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    private Secretaria secretaria;

    @ManyToOne
    private Departamento departamento;

    @OneToOne
    @JoinColumn(name = "computador_id", referencedColumnName = "id")
    private Computador computador;

    @OneToOne
    @JoinColumn(name = "monitor_id", referencedColumnName = "id")
    private Monitor monitor ;

    @OneToOne
    @JoinColumn(name = "estabilizador_id", referencedColumnName = "id")
    private Estabilizador estabilizador;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    private LocalDateTime dataUltimaAlteracao;
}
