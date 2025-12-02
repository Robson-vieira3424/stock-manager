package com.StockManager.Services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.StockManager.Exceptions.InsufficientQuantityException;
import com.StockManager.Exceptions.ProdutNotFoudException;
import com.StockManager.Model.HandlingType;
import com.StockManager.Model.Product;
import com.StockManager.Model.StatusProduct;
import com.StockManager.Repositories.MovementsRepository;
import com.StockManager.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StockManager.Config.ModelMapperConfig;
import com.StockManager.Exceptions.MovementNotFound;
import com.StockManager.Model.Movements;
import com.StockManager.Model.DTO.MovementDTO;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovementsService {

	@Autowired
	private MovementsRepository mRepository;

	@Autowired
	private ProductRepository pRepository;

	public MovementsService(MovementsRepository mrepository, ProductRepository pRepository){
		this.mRepository = mrepository;
		this.pRepository = pRepository;
	}

	
	public List<MovementDTO> findAll() {
		return ModelMapperConfig.parseList(mRepository.findAll(), MovementDTO.class) ;
	}

	public MovementDTO findById(Long id) {
		Movements entity = mRepository.findById(id).orElseThrow(() ->new MovementNotFound("Movimentacão não encontrada!"));
		return ModelMapperConfig.parseObjects(entity, MovementDTO.class)  ;
	}
	public List<MovementDTO> findByType(String type){
        return ModelMapperConfig.parseList(mRepository.findByType(type), MovementDTO.class);
	}
	@Transactional
	public MovementDTO create(MovementDTO dto) {
		Product product = pRepository.findById(dto.getProductId()).orElseThrow(
                () -> new ProdutNotFoudException("Produto não encontrado"));

		if(dto.getType() == HandlingType.INPUT){
		product.setAmount(product.getAmount() + dto.getAmount());
		}
		else if (dto.getType() == HandlingType.OUTPUT){
			if (product.getAmount() >= dto.getAmount()) {
				product.setAmount(product.getAmount() - dto.getAmount());
			}else{
				throw new InsufficientQuantityException("Quantidade de produto insuficiente para realiazar movimentação!");
			}
		}
        if (product.getAmount() == 0) {
            product.setStatus(StatusProduct.Sem_Estoque);


        } else if (product.getAmount() <= product.getMin()) {
            product.setStatus(StatusProduct.Estoque_Baixo);

        } else {
            product.setStatus(StatusProduct.Em_Estoque);
        }

		pRepository.save(product);

        Movements movementEntity = ModelMapperConfig.parseObjects(dto, Movements.class);

        movementEntity.setMoveDate(new Date());

        mRepository.save(movementEntity);

		return dto;

	}
	
	public void delete (Long id) {
		mRepository.deleteById(id);
	}


}
