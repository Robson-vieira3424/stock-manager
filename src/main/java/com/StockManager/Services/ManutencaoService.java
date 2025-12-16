package com.StockManager.Services;

import com.StockManager.Model.*;
import com.StockManager.Model.DTO.ManutencaoDTO;
import com.StockManager.Model.DTO.MovementDTO;
import com.StockManager.Repositories.EquipamentoBaseRepository;
import com.StockManager.Repositories.ManutencaoRepository;
import com.StockManager.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManutencaoService {

    @Autowired
    private ManutencaoRepository manutencaoRepository;

    @Autowired
    private EquipamentoBaseRepository equipamentoBaseRepository;

    @Autowired
    private MovementsService movementsService;

    @Autowired
    private ProductRepository productRepository;

    //TODO QUANDO CRIAR UMA MANUTENCAO: ALTERAR O ESTADO DO EQUIPAMENTO(O DO PATRIMONIO) E DAR BAIXA NOS EQUIPAMENTOS EQUIPAMENTO
    @Transactional
    public ResponseEntity criarManutencao(ManutencaoDTO dto) {
        //Buscar o equipamento pelo ID e alterar o status do equipamento e setar a data da ultima manutencao

        EquipamentoBase equipamento = equipamentoBaseRepository.findByPatrimonio(dto.getPatrimonio())
                .orElseThrow(() -> new RuntimeException("Equipamento não encontratado"));

        equipamento.setStatusEquipamento(StatusEquipamento.MANUTENCAO);

        equipamentoBaseRepository.save(equipamento);

        Manutencao manutencao = new Manutencao();

        manutencao.setEquipamento(equipamento);

        manutencao.setDescricaoProblema(dto.getDescricaoProblema());
        manutencao.setTipo(TipoManutencao.valueOf(dto.getTipo()));
        manutencao.setPrioridade(Prioridade.valueOf(dto.getPrioridade()));

        manutencao.setObservacoes(dto.getObservacao());
        manutencao.setDataPrevisao(dto.getPrevisaoRetorno());

        //TODO: VERIFICAR SE PRECISA DE ALGUMA PEÇA! SE SIM VERFICAR SE TEM SOBRANDO NOS PRODUTOS E DAR BAIXA
        //TODO: SE PRODUTO FOI UTILIZADO CRIAR NOVA MOVIMENTACAO DE SAIDA
        boolean faltaPeca = false;
        List<Product> produtosParaDarBaixa = new ArrayList<>();

        if (Boolean.TRUE.equals(dto.getNecessitaPeca()) && dto.getPecasUtilizadas() != null) {

            for (String nomePeca : dto.getPecasUtilizadas()) {
                Product product = productRepository.findByName(nomePeca)
                        .orElseThrow(() -> new RuntimeException("Peça não encontrada: " + nomePeca));

                if (product.getQuantity() <= 0) {
                    faltaPeca = true;
                } else {
                    produtosParaDarBaixa.add(product);
                }
            }

            if (faltaPeca) {
                manutencao.setStatus(StatusManutencao.AGUARDANDO_PECA);
            } else {
                manutencao.setStatus(StatusManutencao.EM_ANDAMENTO);

                for (Product produto : produtosParaDarBaixa) {
                    MovementDTO movementDTO = new MovementDTO();
                    movementDTO.setProductId(produto.getId());
                    movementDTO.setType(HandlingType.OUTPUT);
                    movementDTO.setAmount(1);

                    movementsService.create(movementDTO);
                    manutencao.adicionarPeca(produto, 1L);
                }
            }

        } else {
            manutencao.setStatus(StatusManutencao.ABERTA);
        }

        Manutencao manutencaoSalva = manutencaoRepository.save(manutencao);
        return ResponseEntity.ok(manutencaoSalva);
       }
    }

