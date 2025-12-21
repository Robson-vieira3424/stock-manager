package com.StockManager.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstacaoTrabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String secretaria;

    private String setor;

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
