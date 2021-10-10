package project.productionplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.productionplanning.dto.ProcessDto;
import project.productionplanning.service.ProcessService;

import java.util.List;

@RestController
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @GetMapping
    public List<ProcessDto> getAllProcesses() {
        return processService.getAllProcesses();
    }

    @GetMapping("/{id}")
    public ProcessDto getProcessById(@PathVariable("id") Integer id) {
        return processService.getProcessById(id);
    }
}
