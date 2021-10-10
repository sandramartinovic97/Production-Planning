package project.productionplanning.service;

import project.productionplanning.dto.SupplierDto;

import java.util.List;

public interface SupplierService {
    List<SupplierDto> getAllSuppliers();
    SupplierDto getSupplierById(Integer id);
    SupplierDto addSupplier(SupplierDto supplierDto);
    SupplierDto updateSupplier(SupplierDto supplierDto, Integer id);
    void deleteSupplier(Integer id);
}
