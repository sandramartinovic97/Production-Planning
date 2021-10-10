package project.productionplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public void addProcess(@RequestBody ProcessDto processDto){
        processService.addProcess(processDto);
    }

    @PutMapping("/{id}")
    public void updateProcess(@RequestBody ProcessDto processDto, @PathVariable("id") Integer id){
        processService.updateProcess(processDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProcess(@PathVariable("id") Integer id) {
        processService.deleteProcess(id);
    }
}
