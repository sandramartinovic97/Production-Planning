package project.productionplanning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.productionplanning.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserUsername(String username);
}
