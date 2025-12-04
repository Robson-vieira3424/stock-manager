package com.StockManager.Controller;

import java.util.List;

import com.StockManager.Model.DTO.ProductInfoCardsDTO;
import com.StockManager.Model.DTO.ResponseProductsCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.StockManager.Model.DTO.ProductDTO;
import com.StockManager.Services.ProductService;



@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	private ProductService pService;
	
	@GetMapping("/{id}")
	public ProductDTO findProduct(@PathVariable Long id) {
		return pService.findById(id);
	}
	
	@GetMapping()
	public List<ProductDTO> findAll() {
		return pService.findAll();
	}

    @GetMapping("/select")
    public List<ResponseProductsCreated> findAllSelect() {
        return pService.findAllSelect();
    }

    @GetMapping("/infos")
    public ProductInfoCardsDTO findInfoCards(){
       return pService.findInfoCards();
    }


	@PostMapping()
	public ProductDTO createProduct(@RequestBody ProductDTO dto) {

		return pService.create(dto);
	}
	
	/*@PutMapping()
	public ProductDTO updateProduct(@RequestBody ProductDTO dto) {
		
		return pService.update(dto);
	}*/
	
	@DeleteMapping("/{id}")
	public void delete( @PathVariable Long id) {
		pService.delete(id);
	}
}
