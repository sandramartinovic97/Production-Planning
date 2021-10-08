package project.productionplanning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.productionplanning.model.Machine;

public interface MachineRepository extends JpaRepository<Machine,Integer> {
}
