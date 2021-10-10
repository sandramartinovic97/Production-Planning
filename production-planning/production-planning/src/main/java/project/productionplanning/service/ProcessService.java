package project.productionplanning.service;

import project.productionplanning.dto.ProcessDto;

import java.util.List;

public interface ProcessService {
    List<ProcessDto> getAllProcesses();
    ProcessDto getProcessById(Integer id);
    ProcessDto addProcess(ProcessDto processDto);
    ProcessDto updateProcess(ProcessDto processDto, Integer id);
    void deleteProcess(Integer id);
}
