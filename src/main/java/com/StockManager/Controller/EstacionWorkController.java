package com.StockManager.Controller;

import com.StockManager.Model.DTO.EstacaoTrabalhoDTO;
import com.StockManager.Services.EstacaoTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController()
@RequestMapping("/estacao")
public class EstacionWorkController {

    @Autowired
    private EstacaoTrabalhoService service;

    @PostMapping
    public void criarEStacaoTrabalho(@RequestBody EstacaoTrabalhoDTO dto){
        service.criarEstacaoTrabalho(dto);

    }
    @GetMapping
    public List<EstacaoTrabalhoDTO> getEstacoesTrabalho(){
        return service.buscarTudo();
    }
}
