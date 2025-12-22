package com.StockManager.Controller;

import com.StockManager.Model.DTO.SecretariaDTO;
import com.StockManager.Model.Departamento;
import com.StockManager.Model.Secretaria;
import com.StockManager.Repositories.DepartamentoRepository;
import com.StockManager.Repositories.SecretariaRepository;
import com.StockManager.Services.SecretariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/secretaria")
public class SecretariaController {

    @Autowired
    private SecretariaService service;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private SecretariaRepository secretariaRepository;

    @PostMapping
    public ResponseEntity<String> cadastrar (@RequestBody SecretariaDTO dto){
        return service.cadastrar(dto);
    }

    @GetMapping
    public ResponseEntity<List<Secretaria>> listarSecretarias(){
        return ResponseEntity.ok().body(secretariaRepository.findAll());
    }

    @GetMapping("/{id}/departamentos")
    public ResponseEntity<List<Departamento>> listarDepartamentosSecretaria(@PathVariable Long id){
        List<Departamento> departamentos = departamentoRepository.findBySecretariaId(id);
        return ResponseEntity.ok().body(departamentos);
    }

}
