package project.productionplanning.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import project.productionplanning.dto.ProductDto;
import project.productionplanning.model.Product;
import project.productionplanning.repository.ProductRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = modelMapper.map(product, ProductDto.class);
            productDtos.add(productDto);
        }
        return productDtos;
    }

    @Override
    public ProductDto getProductById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find product with id = " + id));
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        productRepository.save(product);
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Integer id) {
        Product updatedProduct = modelMapper.map(productDto, Product.class);
        Product productFromDB = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find product with specified id = " + id));
        productFromDB.setProductName(updatedProduct.getProductName());
        productFromDB.setMachineId(updatedProduct.getMachineId());
        return modelMapper.map(productRepository.save(productFromDB), ProductDto.class);
    }

    @Override
    public void deleteProduct(Integer id) {
        jdbcTemplate.execute("delete from document where product_id = " + id);
        jdbcTemplate.execute("delete from part_of_product where product_id = " + id);
        productRepository.deleteById(id);
    }
}
