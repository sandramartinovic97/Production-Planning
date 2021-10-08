package project.productionplanning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.productionplanning.model.Material;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
}
