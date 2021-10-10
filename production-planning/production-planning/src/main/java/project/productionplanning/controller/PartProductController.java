package project.productionplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.productionplanning.dto.PartProductDto;
import project.productionplanning.service.PartProductService;

import java.util.List;

@RestController
@RequestMapping("/partProduct")
public class PartProductController {

    @Autowired
    private PartProductService partProductService;

    @GetMapping
    public List<PartProductDto> getAllPartProducts() {
        return partProductService.getAllPartProducts();
    }

    @GetMapping("/{id}")
    public PartProductDto getPartProductById(@PathVariable("id") Integer id) {
        return partProductService.getPartProductById(id);
    }

}
