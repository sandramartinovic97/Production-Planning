package project.productionplanning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.productionplanning.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
