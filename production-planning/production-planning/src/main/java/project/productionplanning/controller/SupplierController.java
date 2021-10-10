package project.productionplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.productionplanning.dto.SupplierDto;
import project.productionplanning.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/all")
    public List<SupplierDto> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public SupplierDto getSupplierById(@PathVariable("id") Integer id) {
        return supplierService.getSupplierById(id);
    }

    @PostMapping
    public void addSupplier(@RequestBody SupplierDto supplierDto){
        supplierService.addSupplier(supplierDto);
    }

    @PutMapping("/{id}")
    public void updateSupplier(@RequestBody SupplierDto supplierDto, @PathVariable("id") Integer id){
        supplierService.updateSupplier(supplierDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable("id") Integer id) {
        supplierService.deleteSupplier(id);
    }
}
