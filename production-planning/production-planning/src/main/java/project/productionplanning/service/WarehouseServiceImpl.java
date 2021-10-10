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
        Warehouse warehouse = modelMapper.map(warehouseDto, Warehouse.class);
        warehouseRepository.save(warehouse);
        return modelMapper.map(warehouse, WarehouseDto.class);
    }

    @Override
    public WarehouseDto updateWarehouse(WarehouseDto warehouseDto, Integer id) {
        Warehouse updatedWarehouse = modelMapper.map(warehouseDto, Warehouse.class);
        Warehouse warehouseFromDB = warehouseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find warehouse with specified id = " + id));
        warehouseFromDB.setMaterialId(updatedWarehouse.getMaterialId());
        warehouseFromDB.setSupplierId(updatedWarehouse.getSupplierId());
        return modelMapper.map(warehouseRepository.save(warehouseFromDB), WarehouseDto.class);
    }

    @Override
    public void deleteWarehouse(Integer id) {
        warehouseRepository.deleteById(id);
    }
}
