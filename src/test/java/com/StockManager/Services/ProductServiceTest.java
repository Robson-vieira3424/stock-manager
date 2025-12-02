package com.StockManager.Services;

import com.StockManager.Exceptions.ProdutNotFoudException;
import com.StockManager.Model.DTO.ProductDTO;
import com.StockManager.Model.Product;
import com.StockManager.Repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

public class ProductServiceTest {


    ProductRepository repository = Mockito.mock(ProductRepository.class);

    ProductService service = new ProductService(repository);

   /* @Test
    void createProduct(){

        ProductDTO dto = new ProductDTO(1L, "Produto 1", "Descrição", 23, 34242L);
        Product entity = new Product(1L, "Produto 1", "Descrição", 23, 34242L);

        // Mock do save
        when(repository.save(any(Product.class))).thenReturn(entity);

        // Mock do findById
        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        ProductDTO result = service.create(dto);
        ProductDTO buscado = service.findById(1L);

        assertNotNull(result);
        assertEquals("Produto 1", result.getName());

        assertNotNull(buscado);
        assertEquals("Produto 1", buscado.getName());
        assertEquals("Descrição", buscado.getDescription());

    }
*/

    @Test
    void findAll_WhenCalled_ShouldReturnProductList(){

      /*  Product p1 = new Product(1L ,"Produto 1", "Produto 1", 41, 4312414352L);
        Product p2 = new Product(2L ,"Produto 2", "Produto 2", 52, 4312432642L);
        Product p3 = new Product(3L ,"Produto 3", "Produto 3", 424, 4115131242L);
        List<Product> products = List.of(p1,p2,p3);

        ProductDTO dto1 = new ProductDTO(1L ,"Produto 1", "Produto 1", 41, 4312414352L);
        ProductDTO dto2 = new ProductDTO(2L ,"Produto 2", "Produto 2", 52, 4312432642L);
        ProductDTO dto3 = new ProductDTO(3L ,"Produto 3", "Produto 3", 424, 4115131242L);
        List<ProductDTO> productsDto = List.of(dto1,dto2,dto3);


        when(repository.findAll()).thenReturn(products);

        List<ProductDTO> result = service.findAll();

        assertEquals(3, result.size());
        assertEquals(productsDto, result);

    }

    @Test
    void FindProductById(){

        Product entity = new Product(3L, "Produto 3", "Descrição", 23, 34242L);
        when(repository.findById(3L)).thenReturn(Optional.of(entity));


        ProductDTO resultDTO = service.findById(3L);
        Product result = repository.findById(3L).orElseThrow(null);

        assertEquals("Produto 3", resultDTO.getName(), () -> "Erro na busca do nome de um produto!");
        assertEquals(23, result.getAmount(), () -> "Erro na busca da quantidade de um produto!");
    }


    @Test
    void findById_WhenProductNotFound_shouldException(){
        Long id = 82L;

        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ProdutNotFoudException.class, () -> service.findById(id));

        verify(repository).findById(id);
    }


    @Test
    void deleteByIdProduct_whenProductExists_shouldReturnDelete(){
        Long id = 5L;

        service.delete(id);

        verify(repository).deleteById(id);
    }


    @Test
    void deleteProductById_WhenProductNotFound_shouldException() {
        Long id = 34L;

        doThrow( new EntityNotFoundException("O produto não existe pra ser deletado! ")).when(repository).deleteById(id);

        assertThrows(EntityNotFoundException.class, () -> service.delete(id));
   */ }
}
