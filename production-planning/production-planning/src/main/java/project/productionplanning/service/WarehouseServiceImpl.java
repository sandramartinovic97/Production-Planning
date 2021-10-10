package project.productionplanning.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.productionplanning.dto.WarehouseDto;
import project.productionplanning.model.Warehouse;
import project.productionplanning.repository.WarehouseRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<WarehouseDto> getAllWarehouses() {
        List<Warehouse> warehouses = warehouseRepository.findAll();
        List<WarehouseDto> warehouseDtos = new ArrayList<>();
        for (Warehouse warehouse : warehouses) {
            WarehouseDto warehouseDto = modelMapper.map(warehouse, WarehouseDto.class);
            warehouseDtos.add(warehouseDto);
        }
        return warehouseDtos;
    }

    @Override
    public WarehouseDto getWarehouseById(Integer id) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find warehouse with id = " + id));
        return modelMapper.map(warehouse, WarehouseDto.class);
    }

    @Override
    public WarehouseDto addWarehouse(WarehouseDto warehouseDto) {
        return null;
    }

    @Override
    public WarehouseDto updateWarehouse(WarehouseDto warehouseDto, Integer id) {
        return null;
    }

    @Override
    public void deleteWarehouse(Integer id) {

    }
}
