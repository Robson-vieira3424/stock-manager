package com.StockManager.Services;

import com.StockManager.Model.Computador;
import com.StockManager.Model.DTO.ComputadorDTO;
import com.StockManager.Model.DTO.EstabilizadorDTO;
import com.StockManager.Model.DTO.EstacaoTrabalhoDTO;
import com.StockManager.Model.DTO.MonitorDTO;
import com.StockManager.Model.Estabilizador;
import com.StockManager.Model.EstacaoTrabalho;
import com.StockManager.Model.Monitor;
import com.StockManager.Repositories.EstacaoTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class EstacaoTrabalhoService {

    @Autowired
    private ComputadorService computerService;
    @Autowired
    private MonitorService monitorService ;
    @Autowired
    private EstabilizadorService estabilizadorService;

    @Autowired
    private EstacaoTrabalhoRepository estacaoTrabalhoRepository;

    @Transactional
    public void criarEstacaoTrabalho(EstacaoTrabalhoDTO dto){

        ComputadorDTO pc = dto.getComputador();
        MonitorDTO monitor = dto.getMonitor();
        EstabilizadorDTO estab = dto.getEstabilizador();
        String secretaria = dto.getSecretaria();
        String setor = dto.getSetor();

        Computador computadorSalvo = computerService.cadastrarComputador(pc);
        Monitor monitorSalvo = monitorService.cadastrarMonitor(monitor);
        Estabilizador estabilizadorSalvo = estabilizadorService.cadastrarEstabilizador(estab);

        EstacaoTrabalho estacaoTrabalho = new EstacaoTrabalho();

        estacaoTrabalho.setSecretaria(secretaria);
        estacaoTrabalho.setSetor(setor);

        estacaoTrabalho.setComputador(computadorSalvo);
        estacaoTrabalho.setMonitor(monitorSalvo);
        estacaoTrabalho.setEstabilizador(estabilizadorSalvo);

        estacaoTrabalhoRepository.save(estacaoTrabalho);



    }
}
