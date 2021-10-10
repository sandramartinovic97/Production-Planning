package project.productionplanning.service;

import project.productionplanning.dto.MachineDto;

import java.util.List;

public interface MachineService {
    List<MachineDto> getAllMachines();
    MachineDto getMachineById(Integer id);
    MachineDto addMachine(MachineDto machineDto);
    MachineDto updateMachine(MachineDto machineDto, Integer id);
    void deleteMachine(Integer id);
}
