package project.productionplanning.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.productionplanning.dto.PartProductDto;
import project.productionplanning.model.PartProduct;
import project.productionplanning.repository.PartProductRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PartProductServiceImpl implements PartProductService {

    @Autowired
    private PartProductRepository partProductRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PartProductDto> getAllPartProducts() {
        List<PartProduct> partProducts = partProductRepository.findAll();
        List<PartProductDto> partProductDtos = new ArrayList<>();
        for (PartProduct partProduct : partProducts) {
            PartProductDto partProductDto = modelMapper.map(partProduct, PartProductDto.class);
            partProductDtos.add(partProductDto);
        }
        return partProductDtos;
    }

    @Override
    public PartProductDto getPartProductById(Integer id) {
        PartProduct partProduct = partProductRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find part product with id = " + id));
        return modelMapper.map(partProduct, PartProductDto.class);
    }

    @Override
    public PartProductDto addPartProduct(PartProductDto partProductDto) {
        return null;
    }

    @Override
    public PartProductDto updatePartProduct(PartProductDto partProductDto, Integer id) {
        return null;
    }

    @Override
    public void deletePartProduct(Integer id) {

    }
}
