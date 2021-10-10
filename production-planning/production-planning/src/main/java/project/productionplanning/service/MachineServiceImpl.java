package project.productionplanning.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import project.productionplanning.dto.MachineDto;
import project.productionplanning.model.Machine;
import project.productionplanning.repository.MachineRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MachineServiceImpl implements MachineService {

    @Autowired
    private MachineRepository machineRepository;
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private JdbcTemplate jdbcTemplate;

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
        Machine machine = machineRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find machine with id = " + id));
        return modelMapper.map(machine, MachineDto.class);
    }

    @Override
    public MachineDto addMachine(MachineDto machineDto) {
        Machine machine = modelMapper.map(machineDto, Machine.class);
        machineRepository.save(machine);
        return modelMapper.map(machine, MachineDto.class);
    }

    @Override
    public MachineDto updateMachine(MachineDto machineDto, Integer id) {
        Machine updatedMachine = modelMapper.map(machineDto, Machine.class);
        Machine machineFromDB = machineRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find machine with specified id = " + id));
        machineFromDB.setMachineSerialNumber(updatedMachine.getMachineSerialNumber());
        return modelMapper.map(machineRepository.save(machineFromDB), MachineDto.class);
    }

    @Override
    public void deleteMachine(Integer id) {
        jdbcTemplate.execute("delete from product where machine_id = " + id);
        jdbcTemplate.execute("delete from document where machine_id = " + id);
        machineRepository.deleteById(id);
    }
}
