package project.productionplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
