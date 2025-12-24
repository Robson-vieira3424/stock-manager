package com.StockManager.Services;

import com.StockManager.Config.ModelMapperConfig;
import com.StockManager.Model.*;
import com.StockManager.Model.DTO.ComputadorDTO;
import com.StockManager.Model.DTO.EstabilizadorDTO;
import com.StockManager.Model.DTO.EstacaoTrabalhoDTO;
import com.StockManager.Model.DTO.MonitorDTO;
import com.StockManager.Repositories.DepartamentoRepository;
import com.StockManager.Repositories.EstacaoTrabalhoRepository;
import com.StockManager.Repositories.SecretariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstacaoTrabalhoService {

    @Autowired
    private ComputadorService computerService;
    @Autowired
    private MonitorService monitorService ;
    @Autowired
    private EstabilizadorService estabilizadorService;
    @Autowired
    private SecretariaRepository secretariaRepository;
    @Autowired
    private EstacaoTrabalhoRepository estacaoTrabalhoRepository;
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Transactional
    public void criarEstacaoTrabalho(EstacaoTrabalhoDTO dto){
        Secretaria secretaria = secretariaRepository.findById(dto.getSecretariaId())
                .orElseThrow(() -> new RuntimeException("Secretaria não encontrada"));
        Departamento departamento = departamentoRepository.findById(dto.getDepartamentoId())
                .orElseThrow(
                        () -> new RuntimeException("Departamento não encontrado"));

        if (!departamento.getSecretaria().getId().equals(secretaria.getId())) {
            throw new RuntimeException("Departamento não pertence à secretaria informada");
        }


        ComputadorDTO pc = dto.getComputador();
        MonitorDTO monitor = dto.getMonitor();
        EstabilizadorDTO estab = dto.getEstabilizador();


        Computador computadorSalvo = computerService.cadastrarComputador(pc);
        Monitor monitorSalvo = monitorService.cadastrarMonitor(monitor);
        Estabilizador estabilizadorSalvo = estabilizadorService.cadastrarEstabilizador(estab);

        EstacaoTrabalho estacaoTrabalho = new EstacaoTrabalho();


        estacaoTrabalho.setSecretaria(secretaria);
        estacaoTrabalho.setDepartamento(departamento);
        estacaoTrabalho.setComputador(computadorSalvo);
        estacaoTrabalho.setMonitor(monitorSalvo);
        estacaoTrabalho.setEstabilizador(estabilizadorSalvo);

        estacaoTrabalhoRepository.save(estacaoTrabalho);

        System.out.println( dto.toString());

    }

    public List<EstacaoTrabalhoDTO> buscarTudo(){
        return ModelMapperConfig.parseList(estacaoTrabalhoRepository.findAll(), EstacaoTrabalhoDTO.class) ;
    }

}
