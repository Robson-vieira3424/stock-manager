package com.StockManager.Controller;

import com.StockManager.Model.DTO.ManutencaoDTO;
import com.StockManager.Model.DTO.Responses.ManutencaoInfoCards;
import com.StockManager.Services.ManutencaoService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manutencao")
public class ManutencaoController {

    @Autowired
    private ManutencaoService service;

    @PostMapping
    public ResponseEntity criarManutencao(ManutencaoDTO dto){return service.criarManutencao(dto);}

    public void listarManutencoes(){}

    @GetMapping("/infos")
    public ManutencaoInfoCards infoPainelManutencao(){
        return service.infoPainelManutencao();
    }

    @GetMapping()
    public List<ManutencaoDTO> listarManutencao(){
        return service.listarManutencoes();
    }

}
