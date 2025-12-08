package com.StockManager.Services;

import com.StockManager.Config.ModelMapperConfig;
import com.StockManager.Model.Computador;
import com.StockManager.Model.DTO.ComputadorDTO;
import com.StockManager.Repositories.ComputadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputadorService {
    @Autowired
    private ComputadorRepository repository;
    public Computador cadastrarComputador(ComputadorDTO dto){
        Computador entity = ModelMapperConfig.parseObjects(dto, Computador.class);

       return repository.save(entity);
    }

}
