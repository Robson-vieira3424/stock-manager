package com.StockManager.Specifications;

import com.StockManager.Model.Computador;
import com.StockManager.Model.EquipamentoBase;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public class EquipamentoSpecification {

    public static Specification<EquipamentoBase> filtroEquipamentoBase(
            String patrimonio,
            String nomeComputador,
            Long departamentoId){

        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(patrimonio != null){
                predicates.add( criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("patrimonio")),
                        "%" + patrimonio.toLowerCase() + "%"
                ));
            }
            if (nomeComputador != null && !nomeComputador.isBlank()) {

                Root<Computador> computadorRoot =
                        criteriaBuilder.treat(root, Computador.class);

                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(computadorRoot.get("nome")),
                                "%" + nomeComputador.toLowerCase() + "%"
                        )
                );
            }

            if (departamentoId != null) {
                predicates.add(criteriaBuilder.equal(
                        root.get("departamento").get("id"),
                        departamentoId
                ));
            }
            Predicate and = criteriaBuilder.and( predicates.toArray(new Predicate[0]));
            return and;
        };

    }

}
