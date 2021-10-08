package project.productionplanning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.productionplanning.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
