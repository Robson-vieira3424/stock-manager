package com.StockManager.Controller;

import com.StockManager.Model.DTO.ManutencaoDTO;
import com.StockManager.Services.ManutencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manutencao")
public class ManutencaoController {

    @Autowired
    private ManutencaoService service;

    @PostMapping
    public ResponseEntity criarManutencao(ManutencaoDTO dto){return service.criarManutencao(dto);}

    public void listarManutencoes(){}
}
