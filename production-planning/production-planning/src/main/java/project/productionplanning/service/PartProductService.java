package project.productionplanning.service;

import project.productionplanning.dto.PartProductDto;

import java.util.List;

public interface PartProductService {
    List<PartProductDto> getAllPartProducts();
    PartProductDto getPartProductById(Integer id);
    PartProductDto addPartProduct(PartProductDto partProductDto);
    PartProductDto updatePartProduct(PartProductDto partProductDto, Integer id);
    void deletePartProduct(Integer id);
}
