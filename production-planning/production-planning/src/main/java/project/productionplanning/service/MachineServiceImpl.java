package project.productionplanning.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.productionplanning.dto.MachineDto;
import project.productionplanning.dto.ProductDto;
import project.productionplanning.model.Machine;
import project.productionplanning.model.Product;
import project.productionplanning.repository.MachineRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MachineServiceImpl implements MachineService {

    @Autowired
    private MachineRepository machineRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<MachineDto> getAllMachines() {
        List<Machine> machines = machineRepository.findAll();
        List<MachineDto> machineDtos = new ArrayList<>();
        for (Machine machine : machines) {
            MachineDto machineDto = modelMapper.map(machine, MachineDto.class);
            machineDtos.add(machineDto);
        }
        return machineDtos;
    }

    @Override
    public MachineDto getMachineById(Integer id) {
        return null;
    }

    @Override
    public MachineDto addMachine(MachineDto machineDto) {
        return null;
    }

    @Override
    public MachineDto updateMachine(MachineDto machineDto) {
        return null;
    }

    @Override
    public void deleteMachine(Integer id) {

    }
}
