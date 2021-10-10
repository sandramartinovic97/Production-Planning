package project.productionplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.productionplanning.dto.MachineDto;
import project.productionplanning.service.MachineService;

import java.util.List;

@RestController
@RequestMapping("/machine")
public class MachineController {
    @Autowired
    private MachineService machineService;

    @GetMapping
    public List<MachineDto> getMachines() {
        return machineService.getAllMachines();
    }

    @GetMapping("/{id}")
    public MachineDto getMachineById(@PathVariable("id") Integer id) {
        return machineService.getMachineById(id);
    }

    @PostMapping
    public void addMachine(@RequestBody MachineDto machineDto){
        machineService.addMachine(machineDto);
    }

    @PutMapping("/{id}")
    public void updateMachine(@RequestBody MachineDto machineDto, @PathVariable("id") Integer id){
        machineService.updateMachine(machineDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteMachine(@PathVariable("id") Integer id) {
        machineService.deleteMachine(id);
    }
}
