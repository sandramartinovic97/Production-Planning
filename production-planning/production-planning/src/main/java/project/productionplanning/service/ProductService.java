package project.productionplanning.service;

import project.productionplanning.dto.ProductDto;
import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Integer id);
    ProductDto addProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto, Integer id);
    void deleteProduct(Integer id);
}
