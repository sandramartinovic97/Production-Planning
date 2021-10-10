package project.productionplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.productionplanning.dto.SupplierDto;
import project.productionplanning.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<SupplierDto> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public SupplierDto getSupplierById(@PathVariable("id") Integer id) {
        return supplierService.getSupplierById(id);
    }
}
