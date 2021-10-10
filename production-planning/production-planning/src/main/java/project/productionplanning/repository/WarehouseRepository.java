package project.productionplanning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.productionplanning.model.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
}
