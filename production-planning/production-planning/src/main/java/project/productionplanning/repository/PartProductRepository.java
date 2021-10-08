package project.productionplanning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.productionplanning.model.PartProduct;

public interface PartProductRepository extends JpaRepository<PartProduct, Integer> {
}
