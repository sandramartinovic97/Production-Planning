package project.productionplanning.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.productionplanning.dto.ProcessDto;
import project.productionplanning.model.Process;
import project.productionplanning.repository.ProcessRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ProcessRepository processRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ProcessDto> getAllProcesses() {
        List<Process> processes = processRepository.findAll();
        List<ProcessDto> processDtos = new ArrayList<>();
        for (Process process : processes) {
            ProcessDto processDto = modelMapper.map(process, ProcessDto.class);
            processDtos.add(processDto);
        }
        return processDtos;
    }

    @Override
    public ProcessDto getProcessById(Integer id) {
        Process process = processRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find process with id = " + id));
        return modelMapper.map(process, ProcessDto.class);
    }

    @Override
    public ProcessDto addProcess(ProcessDto processDto) {
        return null;
    }

    @Override
    public ProcessDto updateProcess(ProcessDto processDto, Integer id) {
        return null;
    }

    @Override
    public void deleteProcess(Integer id) {

    }
}
