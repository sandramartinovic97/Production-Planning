package project.productionplanning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.productionplanning.model.Process;

public interface ProcessRepository extends JpaRepository<Process, Integer> {
}
