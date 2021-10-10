package project.productionplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.productionplanning.dto.WarehouseDto;
import project.productionplanning.service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping
    public List<WarehouseDto> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    @GetMapping("/{id}")
    public WarehouseDto getWarehouseById(@PathVariable("id") Integer id) {
        return warehouseService.getWarehouseById(id);
    }
}
