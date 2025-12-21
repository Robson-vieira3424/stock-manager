package com.StockManager.Model;

import com.StockManager.Model.DTO.ProductDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipamento_id", nullable = false)
    private EquipamentoBase equipamento;

    @OneToMany(mappedBy = "manutencao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemManutencao> pecasUtilizadas = new ArrayList<>();

    @Column(columnDefinition = "TEXT")
    private String descricaoProblema;

    @Enumerated(EnumType.STRING)
    private TipoManutencao tipo;

    @Enumerated(EnumType.STRING)
    private StatusManutencao status;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    private Boolean utilizouPeca;

    @Column(columnDefinition = "TEXT")
    private String solucaoAplicada;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @CreationTimestamp
    private Date dataInicio;

    private Date dataPrevisao;

    private Date dataFinalizado;

    public void adicionarPeca(Product produto, Long quantidade)
    {
        ItemManutencao item = new ItemManutencao();
        item.setProduto(produto);
        item.setQuantidadeUtilizada(quantidade);
        item.setManutencao(this); // Liga a peça a esta manutenção

        this.pecasUtilizadas.add(item);

    }
}
