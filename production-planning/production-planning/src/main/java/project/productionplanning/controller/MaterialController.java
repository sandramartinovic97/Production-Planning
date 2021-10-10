package project.productionplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.productionplanning.dto.MaterialDto;
import project.productionplanning.service.MaterialService;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping
    public List<MaterialDto> getAllMaterials() {
        return materialService.getAllMaterials();
    }

    @GetMapping("/{id}")
    public MaterialDto getMaterialById(@PathVariable("id") Integer id) {
        return materialService.getMaterialById(id);
    }
}
