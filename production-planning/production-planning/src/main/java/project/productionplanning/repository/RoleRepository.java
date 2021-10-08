package project.productionplanning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.productionplanning.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
