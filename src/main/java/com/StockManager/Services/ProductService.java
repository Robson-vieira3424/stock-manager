package com.StockManager.Services;

import java.util.List;

import com.StockManager.Model.DTO.Responses.ProductInfoCardsDTO;
import com.StockManager.Model.DTO.ResponseProductsCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StockManager.Config.ModelMapperConfig;
import com.StockManager.Exceptions.ProdutNotFoudException;
import com.StockManager.Model.Product;
import com.StockManager.Model.DTO.ProductDTO;
import com.StockManager.Repositories.ProductRepository;
@Service
public class ProductService {

	private ProductRepository pRepository;

	@Autowired
	ProductService(ProductRepository repository){
		this.pRepository= repository;
	}

	public ProductDTO findById(Long id) {
		Product entity = pRepository.findById(id).orElseThrow(() -> new ProdutNotFoudException("Produto não encontrado!"));
		return ModelMapperConfig.parseObjects(entity, ProductDTO.class) ;
	}

	public List<ProductDTO> findAll() {
		return ModelMapperConfig.parseList(pRepository.findAll(), ProductDTO.class);
	}

    public List<ResponseProductsCreated> findAllSelect(){
        return ModelMapperConfig.parseList(pRepository.findAll(), ResponseProductsCreated.class);
    }

    public ProductInfoCardsDTO findInfoCards(){

        Long totalItens =pRepository.countTotalProducts();
        Long unidadesDisponiveis = pRepository.sumTotalInventoryQuantity();
        Long quantidadeItensDisponiveis = pRepository.countByQuantityGreaterThan(0L);
        Long estoqueBaixo = pRepository.countProductsBelowMinimum();

        return new ProductInfoCardsDTO(totalItens, unidadesDisponiveis, quantidadeItensDisponiveis, estoqueBaixo);
    }

	public ProductDTO create(ProductDTO dto) {
		Product entity = ModelMapperConfig.parseObjects(dto, Product.class);
        entity.setName(capitalizeWords(entity.getName()));
		return ModelMapperConfig.parseObjects(pRepository.save(entity), ProductDTO.class);
	}
    /*
    public ProductDTO update(ProductDTO dto) {
		Product entity = pRepository.findById(dto.getId()).orElseThrow(() -> new ProdutNotFoudException("Produto não encontrado!"));
		entity.setName(dto.getName());
		entity.setAmount(dto.getAmount());
		entity.setDescription(dto.getDescription());
		entity.setHeritage(dto.getHeritage());
		
		return ModelMapperConfig.parseObjects(pRepository.save(entity), ProductDTO.class) ;
	}*/

	public void delete(Long id) {
		 pRepository.deleteById(id);
	}

    public static String capitalizeWords(String texto) {
        String[] palavras = texto.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String palavra : palavras) {
            if (palavra.length() > 0) {
                sb.append(palavra.substring(0, 1).toUpperCase())
                        .append(palavra.substring(1).toLowerCase())
                        .append(" ");
            }
        }

        return sb.toString().trim();
    }
}
