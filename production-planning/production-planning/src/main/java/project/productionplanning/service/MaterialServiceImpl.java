package project.productionplanning.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.productionplanning.dto.MaterialDto;
import project.productionplanning.model.Material;
import project.productionplanning.repository.MaterialRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository materialRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<MaterialDto> getAllMaterials() {
        List<Material> materials = materialRepository.findAll();
        List<MaterialDto> materialDtos = new ArrayList<>();
        for (Material material : materials) {
            MaterialDto materialDto = modelMapper.map(material, MaterialDto.class);
            materialDtos.add(materialDto);
        }
        return materialDtos;
    }

    @Override
    public MaterialDto getMaterialById(Integer id) {
        Material material = materialRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find material with id = " + id));
        return modelMapper.map(material, MaterialDto.class);
    }

    @Override
    public MaterialDto addMaterial(MaterialDto materialDto) {
        Material material = modelMapper.map(materialDto, Material.class);
        materialRepository.save(material);
        return modelMapper.map(material, MaterialDto.class);
    }

    @Override
    public MaterialDto updateMaterial(MaterialDto materialDto, Integer id) {
        Material updatedMaterial = modelMapper.map(materialDto, Material.class);
        Material materialFromDB = materialRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find material with specified id = " + id));
        materialFromDB.setMaterialName(updatedMaterial.getMaterialName());
        materialFromDB.setMaterialQuantity(updatedMaterial.getMaterialQuantity());
        materialFromDB.setMaterialSerialNumber(updatedMaterial.getMaterialSerialNumber());
        return modelMapper.map(materialRepository.save(materialFromDB), MaterialDto.class);
    }

    @Override
    public void deleteMaterial(Integer id) {
        materialRepository.deleteById(id);
    }
}
