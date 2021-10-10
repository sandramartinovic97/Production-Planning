package project.productionplanning.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import project.productionplanning.dto.SupplierDto;
import project.productionplanning.model.Supplier;
import project.productionplanning.repository.SupplierRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<SupplierDto> getAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll();
        List<SupplierDto> supplierDtos = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            SupplierDto supplierDto = modelMapper.map(supplier, SupplierDto.class);
            supplierDtos.add(supplierDto);
        }
        return supplierDtos;
    }

    @Override
    public SupplierDto getSupplierById(Integer id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find supplier with id = " + id));
        return modelMapper.map(supplier, SupplierDto.class);
    }

    @Override
    public SupplierDto addSupplier(SupplierDto supplierDto) {
        Supplier supplier = modelMapper.map(supplierDto, Supplier.class);
        supplierRepository.save(supplier);
        return modelMapper.map(supplier, SupplierDto.class);
    }

    @Override
    public SupplierDto updateSupplier(SupplierDto supplierDto, Integer id) {
        Supplier updatedSupplier = modelMapper.map(supplierDto, Supplier.class);
        Supplier supplierFromDB = supplierRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find supplier with specified id = " + id));
        supplierFromDB.setSupplierName(updatedSupplier.getSupplierName());
        supplierFromDB.setSupplierEmail(updatedSupplier.getSupplierEmail());
        supplierFromDB.setSupplierPhone(updatedSupplier.getSupplierPhone());
        supplierFromDB.setSupplierCountry(updatedSupplier.getSupplierCountry());
        supplierFromDB.setSupplierCity(updatedSupplier.getSupplierCity());
        supplierFromDB.setSupplierAddress(updatedSupplier.getSupplierAddress());
        return modelMapper.map(supplierRepository.save(supplierFromDB), SupplierDto.class);
    }

    @Override
    public void deleteSupplier(Integer id) {
        jdbcTemplate.execute("delete from warehouse where supplier_id = " + id);
        supplierRepository.deleteById(id);
    }
}
