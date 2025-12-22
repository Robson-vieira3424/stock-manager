package com.StockManager.Services;

import com.StockManager.Config.ModelMapperConfig;
import com.StockManager.Model.DTO.SecretariaDTO;
import com.StockManager.Model.Departamento;
import com.StockManager.Model.Secretaria;
import com.StockManager.Repositories.SecretariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecretariaService {
    @Autowired
    private SecretariaRepository repository;

    public ResponseEntity<String> cadastrar(SecretariaDTO dto){
        Secretaria secretaria = new Secretaria();
        secretaria.setNome(dto.getNome());

        if(dto.getDepartamentos() != null && !dto.getDepartamentos().isEmpty()){

            List<Departamento> departamentos = new ArrayList<>();
            for (String nomeDept : dto.getDepartamentos()) {
                Departamento dept = new Departamento();
                dept.setNome(nomeDept);
                dept.setSecretaria(secretaria); // VINCULA O PAI NO FILHO!
                departamentos.add(dept);
            }
            secretaria.setDepartamentos(departamentos);
        }
        repository.save(secretaria);

        return ResponseEntity.ok().body("Secretaria Cadastrada com sucesso!");
    }

}
