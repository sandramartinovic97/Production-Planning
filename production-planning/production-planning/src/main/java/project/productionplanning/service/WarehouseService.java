package project.productionplanning.service;

import project.productionplanning.dto.WarehouseDto;

import java.util.List;

public interface WarehouseService {
    List<WarehouseDto> getAllWarehouses();
    WarehouseDto getWarehouseById(Integer id);
    WarehouseDto addWarehouse(WarehouseDto warehouseDto);
    WarehouseDto updateWarehouse(WarehouseDto warehouseDto, Integer id);
    void deleteWarehouse(Integer id);
}
