package com.StockManager.Controller;

import com.StockManager.Model.DTO.Responses.InfoCardsComputer;
import com.StockManager.Services.ComputadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/computador")
public class ComputadorController {
    @Autowired
    private ComputadorService service;

    @GetMapping("/infos")
    public InfoCardsComputer buscarInfoComputadores(){
        return service.buscarInfoComputer();
    }

}
