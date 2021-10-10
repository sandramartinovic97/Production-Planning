package project.productionplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.productionplanning.dto.PartProductDto;
import project.productionplanning.service.PartProductService;

import java.util.List;

@RestController
@RequestMapping("/partProduct")
public class PartProductController {

    @Autowired
    private PartProductService partProductService;

    @GetMapping("/all")
    public List<PartProductDto> getAllPartProducts() {
        return partProductService.getAllPartProducts();
    }

    @GetMapping("/{id}")
    public PartProductDto getPartProductById(@PathVariable("id") Integer id) {
        return partProductService.getPartProductById(id);
    }

    @PostMapping
    public void addPartProduct(@RequestBody PartProductDto partProductDto){
        partProductService.addPartProduct(partProductDto);
    }

    @PutMapping("/{id}")
    public void updatePartProduct(@RequestBody PartProductDto partProductDto, @PathVariable("id") Integer id){
        partProductService.updatePartProduct(partProductDto, id);
    }

    @DeleteMapping("/{id}")
    public void deletePartProduct(@PathVariable("id") Integer id) {
        partProductService.deletePartProduct(id);
    }
}
