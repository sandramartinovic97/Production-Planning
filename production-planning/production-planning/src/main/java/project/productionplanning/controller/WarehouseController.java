package project.productionplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.productionplanning.dto.WarehouseDto;
import project.productionplanning.service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping("/all")
    public List<WarehouseDto> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    @GetMapping("/{id}")
    public WarehouseDto getWarehouseById(@PathVariable("id") Integer id) {
        return warehouseService.getWarehouseById(id);
    }

    @PostMapping
    public void addWarehouse(@RequestBody WarehouseDto warehouseDto){
        warehouseService.addWarehouse(warehouseDto);
    }

    @PutMapping("/{id}")
    public void updateWarehouse(@RequestBody WarehouseDto warehouseDto, @PathVariable("id") Integer id){
        warehouseService.updateWarehouse(warehouseDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteWarehouse(@PathVariable("id") Integer id) {
        warehouseService.deleteWarehouse(id);
    }
}
