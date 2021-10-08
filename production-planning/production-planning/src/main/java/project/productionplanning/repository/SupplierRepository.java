package project.productionplanning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.productionplanning.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
