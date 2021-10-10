package project.productionplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.productionplanning.dto.MaterialDto;
import project.productionplanning.service.MaterialService;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping("/all")
    public List<MaterialDto> getAllMaterials() {
        return materialService.getAllMaterials();
    }

    @GetMapping("/{id}")
    public MaterialDto getMaterialById(@PathVariable("id") Integer id) {
        return materialService.getMaterialById(id);
    }

    @PostMapping
    public void addMaterial(@RequestBody MaterialDto materialDto){
        materialService.addMaterial(materialDto);
    }

    @PutMapping("/{id}")
    public void updateMaterial(@RequestBody MaterialDto materialDto, @PathVariable("id") Integer id){
        materialService.updateMaterial(materialDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteMaterial(@PathVariable("id") Integer id) {
        materialService.deleteMaterial(id);
    }
}
