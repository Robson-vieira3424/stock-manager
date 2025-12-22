package com.StockManager.Services;

import com.StockManager.Config.ModelMapperConfig;
import com.StockManager.Model.DTO.SecretariaDTO;
import com.StockManager.Model.Secretaria;
import com.StockManager.Repositories.SecretariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SecretariaService {
    @Autowired
    private SecretariaRepository repository;

    public ResponseEntity<String> cadastrar(SecretariaDTO dto){
        Secretaria secretaria = new Secretaria();
        secretaria.setNome(secretaria.getNome());

        repository.save(ModelMapperConfig.parseObjects(dto, Secretaria.class));

        return ResponseEntity.ok().body("Secretaria Cadastrada com sucesso!");
    }

}
