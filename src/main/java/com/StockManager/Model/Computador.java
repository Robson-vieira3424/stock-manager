package com.StockManager.Model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Computador extends EquipamentoBase{

    private String processador;

    private String memoria;

    private String armazenamento;

    private String tipo;

    private String Sistema;

    private String nome;

    public Computador() {
    }

    public Computador(String processador, String memoria, String armazenamento, String tipo, String sistema, String nome) {
        super();
        this.processador = processador;
        this.memoria = memoria;
        this.armazenamento = armazenamento;
        this.tipo = tipo;
        this. Sistema = sistema;
        this.nome=nome;
    }
}
