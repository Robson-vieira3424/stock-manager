package com.StockManager.Services;

import com.StockManager.Config.ModelMapperConfig;
import com.StockManager.Model.DTO.EstabilizadorDTO;
import com.StockManager.Model.DTO.MonitorDTO;
import com.StockManager.Model.Estabilizador;
import com.StockManager.Model.Monitor;
import com.StockManager.Model.StatusEquipamento;
import com.StockManager.Repositories.EstabilizadorRepository;
import com.StockManager.Repositories.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitorService {
    @Autowired
    private MonitorRepository repository;

    public Monitor cadastrarMonitor(MonitorDTO dto){
        Monitor entity = ModelMapperConfig.parseObjects(dto, Monitor.class);
        entity.setStatusEquipamento(StatusEquipamento.EM_USO);

        return repository.save(entity);
    }
}
