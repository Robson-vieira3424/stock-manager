package com.StockManager.Services;

import com.StockManager.Config.ModelMapperConfig;
import com.StockManager.Model.DTO.EstabilizadorDTO;
import com.StockManager.Model.Estabilizador;
import com.StockManager.Model.StatusEquipamento;
import com.StockManager.Repositories.EstabilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstabilizadorService {

    @Autowired
    private EstabilizadorRepository repository;

    public Estabilizador cadastrarEstabilizador(EstabilizadorDTO dto){
        Estabilizador entity = ModelMapperConfig.parseObjects(dto, Estabilizador.class);
        entity.setStatusEquipamento(StatusEquipamento.EM_USO);

        return repository.save(entity);
    }

}
