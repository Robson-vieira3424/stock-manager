package com.StockManager.Controller;

import com.StockManager.Model.EquipamentoBase;
import com.StockManager.Repositories.EquipamentoBaseRepository;
import com.StockManager.Specifications.EquipamentoSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/equipamentos")
@CrossOrigin(origins = "*")
public class EquipamentoBaseController {

    @Autowired
    private EquipamentoBaseRepository equipamentoBaseRepository;

    @GetMapping("/busca")
    public List<EquipamentoBase> buscarEquipamentos(
            @RequestParam(required = false) String patrimonio,
            @RequestParam(required = false) String nomeComputador,
            @RequestParam(required = false) Long local
    ){
        Specification<EquipamentoBase> specification = EquipamentoSpecification.filtroEquipamentoBase(patrimonio, nomeComputador, local);
        return equipamentoBaseRepository.findAll(specification);
    }
}
