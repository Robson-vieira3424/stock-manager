package com.StockManager.Model.DTO.Responses;

import java.util.Objects;


public class ProductInfoCardsDTO {

    private Long totalItens;
    private Long unidadesDisponiveis;
    private Long itensDisponiveis;
    private Long estoqueBaixo;

    public ProductInfoCardsDTO(Long totalItens, Long unidadesDisponiveis, Long itensDisponiveis, Long estoqueBaixo) {
        this.totalItens = totalItens;
        this.unidadesDisponiveis = unidadesDisponiveis;
        this.itensDisponiveis = itensDisponiveis;
        this.estoqueBaixo = estoqueBaixo;
    }
    public ProductInfoCardsDTO(){}

    public Long getTotalItens() {
        return totalItens;
    }

    public Long getUnidadesDisponiveis() {
        return unidadesDisponiveis;
    }

    public Long getItensDisponiveis() {
        return itensDisponiveis;
    }

    public Long getEstoqueBaixo() {
        return estoqueBaixo;
    }

    public void setTotalItens(Long totalItens) {
        this.totalItens = totalItens;
    }

    public void setUnidadesDisponiveis(Long unidadesDisponiveis) {
        this.unidadesDisponiveis = unidadesDisponiveis;
    }

    public void setItensDisponiveis(Long itensDisponiveis) {
        this.itensDisponiveis = itensDisponiveis;
    }

    public void setEstoqueBaixo(Long estoqueBaixo) {
        this.estoqueBaixo = estoqueBaixo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductInfoCardsDTO that = (ProductInfoCardsDTO) o;
        return Objects.equals(totalItens, that.totalItens) && Objects.equals(unidadesDisponiveis, that.unidadesDisponiveis) && Objects.equals(itensDisponiveis, that.itensDisponiveis) && Objects.equals(estoqueBaixo, that.estoqueBaixo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalItens, unidadesDisponiveis, itensDisponiveis, estoqueBaixo);
    }
}
