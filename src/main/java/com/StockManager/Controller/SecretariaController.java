package com.StockManager.Controller;

import com.StockManager.Model.DTO.SecretariaDTO;
import com.StockManager.Services.SecretariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secretaria")
public class SecretariaController {

    @Autowired
    private SecretariaService service;

    public ResponseEntity<String> cadastrar (@RequestBody SecretariaDTO dto){
        return service.cadastrar(dto);
    }
}
