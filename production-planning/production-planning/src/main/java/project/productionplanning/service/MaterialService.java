package project.productionplanning.service;

import project.productionplanning.dto.MaterialDto;

import java.util.List;

public interface MaterialService {
    List<MaterialDto> getAllMaterials();
    MaterialDto getMaterialById(Integer id);
    MaterialDto addMaterial(MaterialDto materialDto);
    MaterialDto updateMaterial(MaterialDto materialDto, Integer id);
    void deleteMaterial(Integer id);
}
