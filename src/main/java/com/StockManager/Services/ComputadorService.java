package com.StockManager.Services;

import com.StockManager.Config.ModelMapperConfig;
import com.StockManager.Model.Computador;
import com.StockManager.Model.DTO.ComputadorDTO;
import com.StockManager.Model.DTO.Responses.InfoCardsComputer;
import com.StockManager.Model.StatusEquipamento;
import com.StockManager.Repositories.ComputadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputadorService {

    @Autowired
    private ComputadorRepository repository;

    public Computador cadastrarComputador(ComputadorDTO dto){
        Computador entity = ModelMapperConfig.parseObjects(dto, Computador.class);
        entity.setStatusEquipamento(StatusEquipamento.EM_USO);
         return repository.save(entity);
    }

    public InfoCardsComputer buscarInfoComputer(){
        String total =String.valueOf(repository.count()) ;
        String totalAtivos = String.valueOf(repository.countByStatusEquipamento(StatusEquipamento.EM_USO));
        String totalManutencao = String.valueOf(repository.countByStatusEquipamento(StatusEquipamento.MANUTENCAO));
        String totalInativos = String.valueOf(repository.countByStatusEquipamento(StatusEquipamento.DEFEITO));

        return new InfoCardsComputer(total, totalAtivos, totalManutencao, totalInativos);

    }


}
